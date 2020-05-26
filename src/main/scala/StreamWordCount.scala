import org.apache.flink.api.common.serialization.SimpleStringEncoder
import org.apache.flink.core.fs.Path
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink
import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala._

object StreamWordCount {


  def main(args: Array[String]): Unit = {
    //创建流处理环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    //接受socket文本流
    //val inputDataStream = env.socketTextStream("", 8888)
    /*    val inputDataStream = env.fromCollection(List(SensorReading("hello", 1),
          SensorReading("hello", 1), SensorReading("hello", 1)))*/
    //val inputDataStream = env.addSource(new SourceTest())
    val inputDataStream = env.readTextFile("D:\\Flink\\src\\main\\resources\\reading")
    val resultDataStream: DataStream[String] = inputDataStream
        .map(
          data => {
            val arr = data.split(",")

            SensorReading(arr(0),arr(1).toInt).toString
          }
        )

    // resultDataStream.print()
    /*val result = env.readTextFile("D:\\Flink\\src\\main\\resources\\reading")
    val value : DataStream[(String,Int)] = result.flatMap(_.split(","))
      .map((_, 1))
      .keyBy(data => data._1)
      .sum(1)*/
    resultDataStream.addSink(StreamingFileSink.forRowFormat(
     new Path("D:\\Flink\\src\\main\\resources\\out.txt"),
       new SimpleStringEncoder[String]("UTF-8"))
     .build()
   )
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
