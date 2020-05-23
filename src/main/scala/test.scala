import StreamWordCount.SensorReading
import org.apache.flink.streaming.api.scala._

object test {

  def main(args: Array[String]): Unit = {


    val curTemps = 1.to(10).map(
      i => ("sensor_" + i, 60 + 10)
    )
    println(curTemps)

    val cur = curTemps.map(
      data => (data._1, data._2 + "a")
    )
    print(cur)

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val inputStream: DataStream[SensorReading] = env.readTextFile("D:\\Flink\\src\\main\\resources\\reading")
      .map(
        data => {
          val dataArry = data.split(",")
          SensorReading(dataArry(0), dataArry(1).toInt)
        }
      ).keyBy(data => data.id)
        .reduce((value1,value2) =>{
          SensorReading(value1.id,value1.age.max(value2.age))
        })
    inputStream.print()
    env.execute("ddd")
  }

}
