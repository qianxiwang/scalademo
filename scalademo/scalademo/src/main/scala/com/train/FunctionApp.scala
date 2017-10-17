package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
object FunctionApp {
  def main(args: Array[String]): Unit = {
    //    sayName("lisi")

    //    sayHello()
    //    sayHello

    //    loadConf()

    //    println(speed(100,25))
    //    println(speed(distance = 100,time = 25))
    //    println(speed(time = 25,distance = 100))

    //    println(sum(1, 2, 3, 4, 5))
    //    println(sum(1 to 100:_*))        注意点:       :_*的用法

    //    printCourse("hadoop","hive","spark")
    val array = Array("hadoop", "hive", "spark")
    printCourse(array: _*)

  }

  def printCourse(course: String*) = {
    course.foreach(ele => println(ele))
  }

  def sum(nums: Int*) = {
    var result = 0
    for (num <- nums) {
      result += num
    }
    result
  }

  def sayName(name: String = "zhangsan"): Unit = {
    println(name)
  }

  def sayHello(): Unit = {
    println("hello world")
  }

  def loadConf(conf: String = "spark-default.xml"): Unit = {
    println(conf)
  }

  def speed(distance: Float, time: Float): Float = distance / time
}
