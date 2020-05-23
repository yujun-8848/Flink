import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

object StreamWordCount {


  def main(args: Array[String]): Unit = {
    //创建流处理环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //接受socket文本流
    //val inputDataStream = env.socketTextStream("", 8888)
    /*    val inputDataStream = env.fromCollection(List(SensorReading("hello", 1),
          SensorReading("hello", 1), SensorReading("hello", 1)))*/
    val inputDataStream = env.addSource(new SourceTest())
    /*val resultDataStream: DataStream[(String, Int)] = inputDataStream
      .flatMap(_.split(" "))
      .filter(_.endsWith("o"))
      .map((_, 1))
      .keyBy(0)
      .sum(1)*/
    // resultDataStream.print()
    env.execute()
  }

  case class SensorReading(id: String, age: Int)

  class SourceTest() extends SourceFunction[SensorReading] {

    var running = true

    override def run(sourceContext: SourceFunction.SourceContext[SensorReading]): Unit = {

    }

    override def cancel(): Unit = running = false
  }

}
