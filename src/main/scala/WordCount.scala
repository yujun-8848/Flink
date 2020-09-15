
import org.apache.flink.api.scala._

object WordCount {

  def main(args: Array[String]): Unit = {
    //创建一个批处理的执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val inputDataSet: DataSet[String] = env.readTextFile("D:\\IdeaProjects\\flink\\src\\main\\resources\\wordcount")

    val resultDataSet: DataSet[(String, Int)] = inputDataSet
      .flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)
      .sum(1);
    //resultDataSet.print();
    val value = inputDataSet.flatMap(_.split(" "))
    val value1 = value.map((_, 1))
    val value2 = value1.groupBy(0)
    val value3 = value2.sum(1)
    value3.print()
  }

}
