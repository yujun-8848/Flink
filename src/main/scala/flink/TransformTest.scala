package flink

import org.apache.flink.api.common.functions.FilterFunction
import org.apache.flink.streaming.api.scala._

object TransformTest {

  case class SensorReading(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    //1.基本转换算子
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val value: DataStream[String] = env.readTextFile("D:\\IdeaProjects\\flink\\src\\main\\resources\\reading")
    val dataStream: DataStream[SensorReading] = value.map(data => {
      val dataArray: Array[String] = data.split(",")
      SensorReading(dataArray(0), dataArray(1).toInt)
    })
      .keyBy(_.name)
      //.sum(1)
      .reduce((x, y) => {
        SensorReading(x.name, y.age + 10)
      })

    //多流转换算子
    val splitStream: SplitStream[SensorReading] = dataStream.split(data => {
      if (data.age > 20) Seq("high") else Seq("low")
    })
    val high: DataStream[SensorReading] = splitStream.select("high")
    val low: DataStream[SensorReading] = splitStream.select("low")

    val warnings: DataStream[Int] = high.map(data => data.age)
    val connectedStream: ConnectedStreams[Int, SensorReading] = warnings.connect(low)
    connectedStream.map(data1 => (data1, "warning"),
      data2 => (data2.name, "healthy"))
    // println(connectedStream)
    /*high.print("high")
    low.print("low")*/

    val value1: DataStream[SensorReading] = dataStream.filter(new MyFuncion())

    value1.print()

    env.execute("transform test")
  }

  class MyFuncion() extends FilterFunction[SensorReading] {
    override def filter(t: SensorReading): Boolean = t.age > 20
  }

}


