import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCount {


  def main(args: Array[String]): Unit = {


  }

  def wordCount(): Unit = {
    val input: String = "";
    val output: String = "";
    val conf: SparkConf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("wordcount")
    val sc: SparkContext = new SparkContext(conf)
    val file: RDD[String] = sc.textFile(input)
    val word: RDD[String] = file.flatMap(_.split(" "))
    val sortRdd: RDD[(String, Int)] = word.map((_, 1)).reduceByKey(_ + _)
    sortRdd.saveAsTextFile(output)
  }

  def averHeight(): Unit = {
    //1 20
    //2 23
    //3 12
    //...
    val input: String = "";
    val output: String = "";
    val conf: SparkConf = new SparkConf()
    conf.setAppName("averHeight")
    conf.setMaster("local")
    val sc: SparkContext = new SparkContext(conf)
    val value: RDD[String] = sc.textFile(input)
    val heights: Int = value.map(line => line.split(" ")(1)).map(line => Integer.parseInt(line)).reduce(_ + _)
    val count: Long = value.map(_.split(" ")(0)).count()


  }

  def femaleHeight(): Unit = {
    //1 F 153
    //2 M 185
    //3 M 172
    val input = "";
    val output = "";
    val conf: SparkConf = new SparkConf()
    conf.setAppName("femaleHeight")
    conf.setMaster("local")
    val sc: SparkContext = new SparkContext(conf)
    val value: RDD[String] = sc.textFile(input)
    val FRdd: RDD[String] = value.filter(line => line.contains("F"))
      .map(line => line.split(" ")(1) + " " + line.split(" ")(2))
    val MRdd: RDD[String] = value.filter(line => line.contains("M"))
      .map(line => line.split(" ")(1) + " " + line.split(" ")(2))
    val res: Int = FRdd.map(_.split(" ")(1).toInt).sortBy(x => x, true).first()
  }



}
