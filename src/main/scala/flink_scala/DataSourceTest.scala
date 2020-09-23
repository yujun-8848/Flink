package flink_scala

import org.apache.flink.streaming.api.scala._

/**
 * 数据源包括三种：
 * 1. SourceFunction nonparallelism
 * 2.ParallelSourceFuncion
 * 3.RichParallelSourceFuncion
 */
object DataSourceTest {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    dataSource(env)
    env.execute("DataSourceTest")
  }

  def dataSource(env: StreamExecutionEnvironment): Unit = {
    val value: DataStream[Long] = env.addSource(new CustomDataSource).setParallelism(2)
    value.print()
  }

}
