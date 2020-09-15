package flink

import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time


object WindowTest {

  case class SensorRending(id: String, timeStemp: Long, temprtra: Double)

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    // val value: DataStream[String] = env.readTextFile("D:\\IdeaProjects\\flink\\src\\main\\resources\\reading")
    val value: DataStream[String] = env.socketTextStream("localhost", 7777)
    val dataStream: DataStream[SensorRending] = value.map(data => {
      val dataArray: Array[String] = data.split(",")
      SensorRending(dataArray(0), dataArray(1).toLong, dataArray(2).toDouble)
    })
      .assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor[SensorRending](Time.seconds(1)) {
        override def extractTimestamp(t: SensorRending): Long = t.timeStemp * 1000
      })

    val minTemperWindowStream: DataStream[(String, Double)] = dataStream.map(data => (data.id, data.temprtra))
      .keyBy(_._1)
      //开时间窗口
      .timeWindow(Time.seconds(10))
      .reduce((x, y) => (x._1, x._2.min(y._2)))

    minTemperWindowStream.print("min age")
    dataStream.print("input data")
    env.execute("window test")
  }

}
