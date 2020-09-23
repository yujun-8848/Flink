package flink_scala

import java.io.File
import java.util

import org.apache.commons.io.FileUtils
import org.apache.flink.api.common.functions.RichMapFunction
import org.apache.flink.api.scala._
import org.apache.flink.configuration.Configuration

import scala.collection.mutable.ListBuffer

object DistributedCache {

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val filePah = "C:\\Users\\Administrator\\Desktop\\论文包过\\1.txt"
    env.registerCachedFile(filePah, "localFile")

    val data: DataSet[String] = env.fromElements("1", "2", "3")
    data.map(new RichMapFunction[String, ListBuffer[String]] {

      val builder: ListBuffer[String] = new ListBuffer[String]

      override def open(parameters: Configuration): Unit = {
        val file: File = getRuntimeContext.getDistributedCache.getFile("localFile")

        /**
         * java类型与scala发生异常
         */
        val list: util.List[String] = FileUtils.readLines(file)
        import scala.collection.JavaConverters._
        for (elem <- list.asScala) {
          builder.append(elem)
        }
      }

      override def map(value: String): ListBuffer[String] = {
        for (elem <- builder) {
          elem + value
        }
        for (elem <- builder) {
          println(elem)
        }
        builder
      }
    }).print()
  }

}
