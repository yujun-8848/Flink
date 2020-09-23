package flink_scala

import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.functions.sink.{RichSinkFunction, SinkFunction}
case class Student(name:String, age:Int)
class MySqlSink extends RichSinkFunction[Student]{

  override def invoke(value: Student, context: SinkFunction.Context[_]): Unit = {

  }

  override def open(parameters: Configuration): Unit = super.open(parameters)


  override def close(): Unit = super.close()

  def getConnection(): Unit ={

  }
}
