package com.train

/**
  * Created by Administrator on 2017/10/16.
  */
class ExtendsDemo {

}

/**
  * 子类重写父类方法、属性时，一定要用override修饰
  */
class Student(name: String, age: Int, najor: String) extends Person(name: String, age: Int) {
  println("Student Constructor enter...")

  //  override def toString: String = "Student toString"
  override val school = "peking"

  println("Student Constructor leave...")
}


object ExtendsDemo {
  def main(args: Array[String]): Unit = {
    val student = new Student("amy", 21, "bigdata")

    println(student.toString)
    println(student.school)
  }
}
