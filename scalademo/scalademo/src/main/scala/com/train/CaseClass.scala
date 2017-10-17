package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
object CaseClass {
  def main(args: Array[String]): Unit = {
    Dog("wangcai")
  }
}

case class Dog(name: String)