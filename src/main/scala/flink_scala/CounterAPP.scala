package flink_scala

import org.apache.flink.api.common.JobExecutionResult
import org.apache.flink.api.common.accumulators.LongCounter
import org.apache.flink.api.common.functions.RichMapFunction
import org.apache.flink.api.scala._
import org.apache.flink.configuration.Configuration
import org.apache.flink.core.fs.FileSystem.WriteMode


object CounterAPP {

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    //val value: DataSet[String] = env.readTextFile("D:\\Flink\\src\\main\\resources\\wordcount")
    val value: DataSet[String] = env.fromElements("1", "2", "3", "4")
    val data: DataSet[String] = value.map(new RichMapFunction[String, String]() {
      //step1:定义计数器
      val counter: LongCounter = new LongCounter()
      override def open(parameters: Configuration): Unit = {
        //step2:注册计数器
        getRuntimeContext.addAccumulator("counter", counter)
      }
      override def map(in: String): String = {
        counter.add(1)
        in
      }
    }).setParallelism(5)
    data.writeAsText("C:\\Users\\Administrator\\Documents\\WXWorkLocal\\1688849873270957\\Cache\\File\\2020-09\\论文资源", WriteMode.OVERWRITE)
    val result: JobExecutionResult = env.execute("counterApp")
    //step3:获取计数器
    val count: Long = result.getAccumulatorResult("counter")
    print(count)

  }

}
