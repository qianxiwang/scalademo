package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
class ConstructorDemo {

}

//主构造器
class Person(val name: String, val age: Int) {
  println("Person Constructor enter...")
  val school = "ustc"
  var gender: String = _
  println("Person Constructor leaver...")

  /**
    * this 修饰的是附属构造器
    * 每个附属构造器的第一行必须调用以及功能存在的主构造器或者其他附属构造器
    */
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
}

object ConstructorDemo {
  def main(args: Array[String]): Unit = {
    val person = new Person("amy", 20)
    println(person.name)

    val person2 = new Person("amy", 20, "female")
    println(person2.name + "," + person2.age + "," + person2.gender)
  }
}