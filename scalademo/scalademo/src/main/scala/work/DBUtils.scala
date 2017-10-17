package work

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}

object DBUtils {

  val url = "jdbc:mysql://localhost:3306/test"
  val username = "root"
  val password = "000000"

  classOf[com.mysql.jdbc.Driver]

  def getConnection(): Connection = {
    DriverManager.getConnection(url, username, password)
  }

  def close(conn: Connection): Unit = {
    try {
      if (!conn.isClosed() || conn != null) {
        conn.close()
      }
    }
    catch {
      case ex: Exception => {
        ex.printStackTrace()
      }
    }
  }

  def close(rs: ResultSet): Unit = {
    try {
      if (!rs.isClosed() || rs != null) {
        rs.close()
      }
    }
    catch {
      case ex: Exception => {
        ex.printStackTrace()
      }
    }
  }

  def close(pstm: PreparedStatement): Unit = {
    try {
      if (!pstm.isClosed() || pstm != null) {
        pstm.close()
      }
    }
    catch {
      case ex: Exception => {
        ex.printStackTrace()
      }
    }
  }
}
