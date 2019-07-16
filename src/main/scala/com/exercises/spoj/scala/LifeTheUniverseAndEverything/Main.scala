import scala.annotation.tailrec
//package com.exercises.spoj.scala.LifeTheUniverseAndEverything

object Main extends App { //OK
  @tailrec
  def readAndPrintInput():Unit = {
    val in = scala.io.StdIn.readInt()
    if (in != 42){
      println(in)
      readAndPrintInput()
    }
  }
  readAndPrintInput()
}
