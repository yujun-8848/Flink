import org.apache.flink.api.scala._

object addressTotal {

  case class address(ID: String, STD_ID: String, SPLIT_FLAG: String, CHECK_FLAG: String, ORG_ADDR: String, PROVINCE: String, CITY: String, COUNTRY: String,
                     TOWN: String, VILLAGE: String, ROAD: String, NUMBER: String, POI: String, BUILDING: String, UNIT: String, FLOOR: String, ROOM: String,
                     LON: String, LAT: String, LAST_DIS_PLACE: String, TRAC_INF: String, UPD_TIME: Long, NORMA_STAT_BNO: Int)

  def main(args: Array[String]): Unit = {
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val data: DataSet[String] = env.readTextFile("D:\\Flink\\src\\main\\resources\\addressTest")

    val dataAll: DataSet[address] = data.map(data => {
      val strings: Array[String] = data.split("\t")
      address(strings(0).trim, strings(1).trim, strings(2).trim, strings(3).trim, strings(4).trim, strings(5).trim, strings(6).trim, strings(7).trim, strings(8).trim, strings(9).trim, strings(10).trim, strings(11).trim,
        strings(12).trim, strings(13).trim, strings(14).trim, strings(15).trim, strings(16).trim, strings(17).trim, strings(18).trim, strings(19).trim,
        strings(20).trim, strings(21).trim.toLong, strings(22).trim.toInt)
    })
    val total: Long = dataAll.count()
    val hasValue: Long = dataAll.filter(_.NORMA_STAT_BNO == 0).count()

    println("归一化总条数：" + total)
    println("归一化成功条数：" + hasValue)
    //取值为小数
    print("归一化成功率：" + (hasValue * 1.0/total))


  }

}
