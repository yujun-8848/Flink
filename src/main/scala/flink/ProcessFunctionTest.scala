package flink

import flink.WindowTest.SensorRending
import org.apache.flink.api.common.functions.{FlatMapFunction, RichFlatMapFunction}
import org.apache.flink.api.common.state.{ValueState, ValueStateDescriptor}
import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.functions.KeyedProcessFunction
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.util.Collector

object ProcessFunctionTest {

  def main(args: Array[String]): Unit = {

    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(1)
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)

    val value: DataStream[String] = env.socketTextStream("localhost", 7777)
    val dataStream: DataStream[SensorRending] = value.map(data => {
      val strings: Array[String] = data.split(",")
      SensorRending(strings(0), strings(1).toLong, strings(2).toDouble)
    }).assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor[SensorRending](Time.seconds(1)) {
      override def extractTimestamp(element: SensorRending): Long = element.timeStemp * 1000
    })

    val processStream: DataStream[String] = dataStream.keyBy(_.id)
      .process(new TempIncreAlert())

    val processStream2: DataStream[(String, Double, Double)] = dataStream.keyBy(_.id)
      .flatMap(new TempChangeAlert(10.0))
    dataStream.print("input data")
    processStream2.print("processStream")
    env.execute()


  }

  class TempChangeAlert(threashould: Double) extends RichFlatMapFunction[SensorRending, (String, Double, Double)] {

    private var lastTempState: ValueState[Double] = _

    override def open(parameters: Configuration): Unit = {
      lastTempState = getRuntimeContext.getState(new ValueStateDescriptor[Double]("lastTemp", classOf[Double]))

    }

    override def flatMap(value: SensorRending, out: Collector[(String, Double, Double)]): Unit = {
      //取上一个温度值
      val lastTemp: Double = lastTempState.value()

      //更新温度值
      lastTempState.update(value.temprtra)

      val diff: Double = (lastTemp - value.temprtra).abs
      if (diff > threashould) {
        out.collect((value.id, lastTemp, value.temprtra))
      }


    }
  }

  class TempIncreAlert extends KeyedProcessFunction[String, SensorRending, String] {

    //定义一个状态，用来保存上一个数据的温度值
    lazy val lastTemp: ValueState[Double] = getRuntimeContext.getState(new ValueStateDescriptor[Double]("lastTemp", classOf[Double]))

    //定义一个状态，用来保存定时器的时间戳
    lazy val currentTimer: ValueState[Long] = getRuntimeContext.getState(new ValueStateDescriptor[Long]("currentTimer", classOf[Long]))

    override def processElement(value: SensorRending, ctx: KeyedProcessFunction[String, SensorRending, String]#Context, out: Collector[String]): Unit = {
      //先取出上一个温度值
      val preTemp: Double = lastTemp.value()
      //更新温度值
      lastTemp.update(value.temprtra)

      val curTimerTs: Long = currentTimer.value()
      //温度上升，则注册定时器
      if (value.temprtra > preTemp && curTimerTs == 0) {
        val timerTs: Long = ctx.timerService().currentProcessingTime() + 10000L
        ctx.timerService().registerProcessingTimeTimer(timerTs)
        currentTimer.update(timerTs)
      } else if (preTemp > value.temprtra || preTemp == 0.0) {
        //如果温度下降，或者是第一条数据，删除定时器并清空状态
        ctx.timerService().deleteProcessingTimeTimer(curTimerTs)
        currentTimer.clear()

      }
    }

    override def onTimer(timestamp: Long, ctx: KeyedProcessFunction[String, SensorRending, String]#OnTimerContext, out: Collector[String]): Unit = {
      //输出报警信息
      out.collect(ctx.getCurrentKey + "温度连续上升")
      currentTimer.clear()
    }


  }

  class TempChangeAlert2(throead: Double) extends KeyedProcessFunction[String, SensorRending, (String, Double, Double)] {

    lazy val lastTempState: ValueState[Double] = getRuntimeContext.getState(new ValueStateDescriptor[Double]("lastTemp", classOf[Double]))

    override def processElement(value: SensorRending, ctx: KeyedProcessFunction[String, SensorRending, (String, Double, Double)]#Context, out: Collector[(String, Double, Double)]): Unit = {

      //取上一个温度值
      val lastTemp: Double = lastTempState.value()

      //更新温度值
      lastTempState.update(value.temprtra)

      val diff: Double = (lastTemp - value.temprtra).abs
      if (diff > throead) {
        out.collect((ctx.getCurrentKey, lastTemp, value.temprtra))
      }

    }
  }

}



