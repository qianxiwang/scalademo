package com.train


/**
  * Created by Administrator on 2017/10/17.
  */
object MatchApp {
  def main(args: Array[String]): Unit = {
    //    val array = Array("Akiho Yoshizawa", "YuiHatano", "Aoi Sola")
    //    val name = array(Random.nextInt(array.length))
    //
    //    name match {
    //      case "Akiho Yoshizawa" => println("ji")
    //      case "YuiHatano" => println("bo")
    //      case _ => println("不知道你在说什么")
    //    }

    //   judegGrade("F")
    //    judegGrade("zhangsan","A")
    //      judegGrade("qianxi","F")

    greeting(Array("James", "huhuhu", "zhangsan"))
  }

  def greeting(array: Array[String]): Unit = {
    array match {
      case Array("zhangsan") => println("zhangsan")
      case Array(x, y) => println(x + ":" + y)
      case Array("zhangsan", _*) => println("zhangsan and others")
      case _ => println("everyone")
    }

  }

  def judegGrade(name: String, grade: String): Unit = {
    grade match {
      case "A" => println("很好")
      case "B" => println("good")
      case "C" => println("so so")
      case _ if name == "qianxi" => println("so so")
      case _ => println("Worse")
    }

    //  def judegGrade(grade:String): Unit ={
    //    grade match {
    //      case "A"=>println("很好")
    //      case "B"=>println("good")
    //      case "C"=>println("so so")
    //      case _=>println("Worse")
    //    }


  }
}
