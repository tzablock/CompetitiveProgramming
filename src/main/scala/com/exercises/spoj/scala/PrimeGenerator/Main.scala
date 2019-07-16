package com.exercises.spoj.scala.PrimeGenerator

object Main extends App { // Time exceed
//  t<=10
//  1 <= m <= n <= 1000000000, n-m<=100000
//  m <= p <= n
  val t = scala.io.StdIn.readInt()
  (1 to t).toStream.map( i => {
    val lowHighBounds = scala.io.StdIn.readLine()
    val lowBound = lowHighBounds.split(" ")(0).toInt
    val highBound = lowHighBounds.split(" ")(1).toInt
    (lowBound, highBound)
  }).map {
    case (l, h) =>
      (l to h).filter(
        isPrime
      ).map(_.toString)
  }.map(
    b => b ++ IndexedSeq(" ")
  ).foreach(
    b => b.foreach(println)
  )

  private def isPrime(num: Int): Boolean = num != 1 && !(2 to Math.sqrt(num).toInt).exists(sn => num%sn == 0)
}
