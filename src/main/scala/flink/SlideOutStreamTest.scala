package flink

import flink.ProcessFunctionTest.TempIncreAlert
import flink.WindowTest.SensorRending
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.functions.ProcessFunction
import org.apache.flink.streaming.api.scala._
import org.apache.flink.util.Collector

object SlideOutStreamTest {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    env.setParallelism(1)
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)

    val value: DataStream[String] = env.socketTextStream("localhost", 7777)
    val dataStream: DataStream[SensorRending] = value.map(data => {
      val strings: Array[String] = data.split(",")
      SensorRending(strings(0), strings(1).toLong, strings(2).toDouble)
    })

    val processStream: DataStream[SensorRending] = dataStream
      .process(new FreezingAlert())

    processStream.print("input data")
    processStream.getSideOutput(new OutputTag[String]("freezing alert")).print("alert data")
    env.execute()
    Tuple1

  }

  //冰点报警，如果小于32F，输出报警信息到侧输出流
  class FreezingAlert extends ProcessFunction[SensorRending, SensorRending] {

    lazy val alertOutput: OutputTag[String] = new OutputTag[String]("freezing alert")

    override def processElement(value: SensorRending, ctx: ProcessFunction[SensorRending, SensorRending]#Context, out: Collector[SensorRending]): Unit = {
      if (value.temprtra < 32.0) {
        ctx.output(alertOutput, "freezing alert for"+value.id)
      }else{
        out.collect(value)
      }
    }
  }

}
