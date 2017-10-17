package connect

object TestScala {

  def main(args: Array[String]): Unit = {
    try {
      //      此时是否连接正常
      //          println(DBUtils.getConnection())

      val op = new Operators()

      //插入一条数据
      val user = op.User("4", "Test", 40)
      //      println(op.add(user))

      //更新一条记录
      //      println(op.update(user))

      //查询所有
      println(op.query())

      //      根据id进行查询
      //            println(op.query_id(1))

      //删除一条记录
      //             println(op.delete("4"))
    }
    catch {
      case ex: Exception => ex.printStackTrace()
    }
  }
}
