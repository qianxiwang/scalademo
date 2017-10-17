package connect

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Operators {

  //查询所有
  def query(): ArrayBuffer[mutable.HashMap[String, Any]] = {
    val conn = MySqlPool.getJdbcConn()
    try {
      val sql = "select * from user"
      val pstm = conn.prepareStatement(sql.toString())
      val rs = pstm.executeQuery()

      val rsmd = rs.getMetaData()
      val size = rsmd.getColumnCount()
      val buffer = new ArrayBuffer[mutable.HashMap[String, Any]]()
      while (rs.next()) {
        val map = mutable.HashMap[String, Any]()
        for (i <- 1 to size) {
          map += (rsmd.getColumnLabel(i) -> rs.getString(i))
        }
        buffer += map
      }
      buffer
    }
    finally {
      MySqlPool.releaseConn(conn)
    }
  }

  //插入一条数据
  def add(user: User): Boolean = {
    val conn = MySqlPool.getJdbcConn()
    try {
      val sql = "insert into user(id, name, age) values(?, ?, ?)"
      val pstm = conn.prepareStatement(sql.toString())
      pstm.setObject(1, user.id)
      pstm.setObject(2, user.name)
      pstm.setObject(3, user.age)

      pstm.executeUpdate() > 0
    }
    finally {
      MySqlPool.releaseConn(conn)
    }
  }

  //根据id查询单条数据
  def query_id(id: Int): ArrayBuffer[mutable.HashMap[String, Any]] = {
    val conn = MySqlPool.getJdbcConn()
    try {
      val sql = "select name, age from user where id = ?"
      val pstm = conn.prepareStatement(sql.toString())
      pstm.setObject(1, id)
      val rs = pstm.executeQuery()

      val rsmd = rs.getMetaData()
      val size = rsmd.getColumnCount()
      val buffer = new ArrayBuffer[mutable.HashMap[String, Any]]()
      while (rs.next()) {
        val map = mutable.HashMap[String, Any]()
        for (i <- 1 to size) {
          map += (rsmd.getColumnLabel(i) -> rs.getString(i))
        }
        buffer += map
      }

      buffer
    }
    finally {
      MySqlPool.releaseConn(conn)
    }
  }

  //删除一条数据
  def delete(id: String): Boolean = {
    val conn = MySqlPool.getJdbcConn()
    try {
      val sql = "delete from user where id = ?"
      val pstm = conn.prepareStatement(sql.toString)
      pstm.setObject(1, id)

      pstm.executeUpdate() > 0
    }
    finally {
      MySqlPool.releaseConn(conn)
    }
  }

  //更新一条数据
  def update(user: User): Boolean = {
    val conn = MySqlPool.getJdbcConn()
    try {
      val sql = "update user set age = ? where id = ?"
      val pstm = conn.prepareStatement(sql)
      pstm.setObject(1, user.age)
      pstm.setObject(2, user.id)

      pstm.executeUpdate() > 0
    }
    finally {
      MySqlPool.releaseConn(conn)
    }
  }

  case class User(id: String, name: String, age: Int)


}
