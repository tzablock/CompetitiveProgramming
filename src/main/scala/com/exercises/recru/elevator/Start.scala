package com.exercises.recru.elevator

import scala.annotation.tailrec

object Start {
  def main(args: Array[String]): Unit = {
    val numElev = args(0).toInt
    val floorNum = args(1).toInt
    val es = ElevatorsQueueService.init(args(0).toInt) match {
      case Right(es) => es
      case Left(e) => println(e.message)
                      return;
    }

    val nes = es.orderElevator(1)
                .orderElevator(4)
                .orderElevator(2)
                .orderElevator(9)
        .orderElevator(10)
        .orderElevator(3)
        .orderElevator(4)
        .orderElevator(4)

    checkFloors(floorNum, nes)
  }

  @tailrec
  def checkFloors(fn: Int, es: ElevatorsQueueService): Unit = {
    if (es.moreOrders()){
      if (fn <= 0){
        checkFloors(10, es.elevatorCome(fn))
      } else {
        checkFloors(fn-1, es.elevatorCome(fn))
      }
    }
  }
}
