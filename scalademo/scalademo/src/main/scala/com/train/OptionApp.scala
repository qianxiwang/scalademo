package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
object OptionApp {
  def main(args: Array[String]): Unit = {
    val m = Map(1 -> 2)
    //    println(m(1))

    println(m.get(1) + ":" + m.get(1).get)
    println(m.get(2) + ":" + m.get(2).getOrElse(0))

  }
}
