package flink_scala

import org.apache.flink.api.java.aggregation.Aggregations
import org.apache.flink.api.scala._

import scala.collection.mutable.ListBuffer

object ScalaTest {

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    //join(env)
    reduce(env)
    //aggrega(env)
  }

  def join(env: ExecutionEnvironment): Unit = {
    val list: ListBuffer[(Int, String)] = new ListBuffer[(Int, String)]
    list.append((1, "uzi"))
    list.append((2, "xiaohu"))
    list.append((3, "ming"))
    list.append((4, "long"))

    val list2: ListBuffer[(Int, String)] = new ListBuffer[(Int, String)]
    list2.append((1, "ADC"))
    list2.append((2, "Mid"))
    list2.append((4, "jug"))

    val data1: DataSet[(Int, String)] = env.fromCollection(list)
    val data2: DataSet[(Int, String)] = env.fromCollection(list2)
    data1.leftOuterJoin(data2).where(0).equalTo(0).apply((x: (Int, String), y: (Int, String)) => {
      if (y == null) {
        (x._1, x._2, "-", "-")
      } else {
        (x._1, x._2, y._1, y._2)
      }
    }).print()

  }

  def reduce(env: ExecutionEnvironment): Unit = {
    val list: ListBuffer[(Int, String)] = new ListBuffer[(Int, String)]
    list.append((1, "uzi"))
    list.append((2, "xiaohu"))
    list.append((2, "xiaohu1"))
    list.append((2, "xiaohu2"))
    list.append((3, "ming"))
    list.append((4, "long"))

    val list2: ListBuffer[(Int, String)] = new ListBuffer[(Int, String)]
    list2.append((1, "ADC"))
    list2.append((2, "Mid"))
    list2.append((4, "jug"))

    val data1: DataSet[(Int, String)] = env.fromCollection(list)
    val data2: DataSet[(Int, String)] = env.fromCollection(list2)
//    data1.groupBy(0).reduce((x: (Int, String), y: (Int, String)) => {
//      (x._1,y._2+ "-A")
//    }).print()
    data1.distinct(0).print()


  }

  def aggrega(env: ExecutionEnvironment): Unit = {
    val value: DataSet[(Int, String, Int)] = env.fromElements((1, "a", 3), (2, "b", 3), (2, "c", 1))
    value.groupBy(0).aggregate(Aggregations.SUM, 0).aggregate(Aggregations.MIN, 2).print()
  }


}
