package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
class ObjectDemo {

  var count = 0

  def printInfo(): Unit = {
    println(count)
  }

  def apply() = {
    println("class  apply enter...")
  }

  def incr = {
    count = count + 1
  }
}

/**
  * class修饰的和object修饰的叫做: 伴生
  */
object ObjectDemo {
  println("Object enter...")

  var count = 0

  /**
    * apply是伴生对象中一个非常重要的方法
    * 通常在伴生对象的apply方法中实现伴生类的构造功能
    *
    * 在创建伴生对象时，通常不使用new ，而是apply(),底层隐式调用apply()方法完成构造
    * 类名()  ==>  object apply
    * 对象()  ==>  class apply
    */
  def apply() = {
    println("Object  apply enter...")
    new ObjectDemo
  }

  def incr = {
    count = count + 1
  }

  println("Object leave...")
}

object ApplyDemo {
  def main(args: Array[String]): Unit = {

    //    val a = new ObjectDemo()
    //    println(a)
    //
    //    val b = ObjectDemo()
    //    b.printInfo()


    val a = new ObjectDemo()
    //    println(a + ",,,,,,,,,,,,,,,,,,,")
    //    println(ObjectDemo() + "....................")

    println("======================")
    a()

    //    for(i<-1 to 10){
    //      ObjectDemo.incr
    //    val demo = new ObjectDemo()
    //      demo.incr
    //      println(demo.count)
    //    }


    //    println(ObjectDemo.count)   //object其实是一个单例对象
  }
}

