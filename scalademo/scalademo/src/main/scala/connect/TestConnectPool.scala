package connect

package test.testConnectionPoll

/**
  * 测试获取数据库连接池
  */
object TestConnectPool {
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 20) {
      val con = MySqlPool.getJdbcConn()
      println("当前连接：" + x + "  " + con)
      if (x == 6) {
        println("释放的是：" + x + " " + con)
        MySqlPool.releaseConn(con)
      }
    }
  }
}