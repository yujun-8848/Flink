package flink_scala

import org.apache.flink.api.scala._
import org.apache.flink.core.fs.FileSystem.WriteMode

object DataSourceSink {

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val value: DataSet[String] = env.readTextFile("D:\\Flink\\src\\main\\resources\\wordcount")
    value.flatMap(_.split(" "))
      .map((_,1))
      .groupBy(0)
      .sum(1)
      .print()
    value.writeAsText("C:\\Users\\Administrator\\Desktop\\hot",WriteMode.OVERWRITE)
    env.execute()
  }

}
