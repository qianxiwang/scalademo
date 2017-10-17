package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
class AbstractDemo {

}

/**
  * 类的一个或者多个方法没有完整的实现（只有定义，没有方法体）
  * 使用abstract修饰类
  */
abstract class Person2() {
  val name: String
  val age: Int

  def speak
}

class Student2 extends Person2 {
  val name = "zhangsan"
  val age = 44

  override def speak: Unit = {
    println("speak.....")
  }
}

object AbstractDemo {
  def main(args: Array[String]): Unit = {
    val s = new Student2
    println(s.age + s.name)

    s.speak
  }
}
