package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
object MapApp {
  def main(args: Array[String]): Unit = {
    val a = Map("huhuhu" -> 21, "feiji" -> 44)

    for ((key, value) <- a) {
      println(key + "," + value)
    }

    println("===========================")

    for (key <- a.keySet) {
      println(key + ":" + a.getOrElse(key, 0))
    }

    println("===========================")

    for ((key, _) <- a) {
      println(key + ":" + a.getOrElse(key, 0))
    }

    //    val c = scala.collection.mutable.HashMap[String,Int]()
    //    c.getOrElse("huhuhu",4)
  }
}
