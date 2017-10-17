package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
class SimpleObjectDemo {

}

//定义一个类
class People {

  //定义属性
  //  val age: Int = 10
  val age = 10
  private[this] val gender = "male" //private修饰的属性或者方法的作用域只能是当前类
  var d: Double = _
  var i: Int = _
  var s: String = _
  var name: String = ""

  def printInfo(): Unit = {
    println("gender: " + gender)

  }

  //定义方法
  def eat(): String = {
    name + " eat..."
  }

  def watchFootball(teamName: String): String = {
    name + " is watch" + teamName
  }

}

object SimpleObjectDemo {
  def main(args: Array[String]): Unit = {
    val people = new People
    people.name = "Amy"

    //    println(people.name + "," + people.age)
    //    println(people.eat())
    //    println(people.watchFootball("aaaaaaaaaaaaaaa"))

    println(people.s)
    people.printInfo()
    //    println(people.name+":"+people.gender)    //会报错
  }
}