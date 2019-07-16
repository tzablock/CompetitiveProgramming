package com.exercises.recru.elevator

class ElevatorsQueueService(orders: Map[Int, List[Int]], system: ElevatorSystem) {
  // user -> (click bottom with floor) -> ElevatorsQueueService
  // -> (check which elevator to send) -> (add order to queue for elevator nr n) -> (send new map to system)
  def orderElevator(floor: Int): ElevatorsQueueService = {
    val (floorOrdered, elevatorNum) = checkIfFloorOrdered(floor)
    if (floorOrdered) {
      println(s"Floor number ${floor} already ordered for elevator ${elevatorNum}")
      this
    } else {
      val elevNum = chooseElevator()
      //send order into low lvl elevator system
      val sys = system.updateOrders(elevNum, floor)
      ElevatorsQueueService(orders + (elevNum -> (orders(elevNum) ++ List(floor))), sys)
    }
  }
  //check in low lvl system if elevator come
  def elevatorCome(floor: Int): ElevatorsQueueService = {
    val (floorOrdered, elevatorNum) = checkIfFloorOrdered(floor)
    if (!floorOrdered){
      this
    } else {
      checkInSystem(floor, elevatorNum)
    }
  }

  def moreOrders(): Boolean = {
    orders.exists(_._2.nonEmpty)
  }

  private def checkInSystem(floor: Int, elevatorNum: Int): ElevatorsQueueService = {
    val (ifElevatorCome, sys) = system.ifElevatorCome(floor, orders(elevatorNum))
    if (ifElevatorCome) {
      ElevatorsQueueService(removeElevatorFromQueue(elevatorNum, floor), sys)
    } else {
      ElevatorsQueueService(orders, sys)
    }
  }

  private def chooseElevator():Int = {
    orders.map(e => (e._1, e._2.size)).minBy(_._2)._1
  }

  private def checkIfFloorOrdered(floor: Int): (Boolean, Int) = {
    val elevNumberList = orders.filter(_._2.contains(floor)).keys
    if (elevNumberList.isEmpty) {
      (false, 0)
    } else {
      (true, elevNumberList.head)
    }
  }

  private def removeElevatorFromQueue(elevatorNum: Int, floor: Int): Map[Int, List[Int]] = {
    orders + (elevatorNum -> orders(elevatorNum).filter(_ != floor))
  }
}
object ElevatorsQueueService{
  def apply(elevators: Map[Int, List[Int]], system: ElevatorSystem): ElevatorsQueueService = new ElevatorsQueueService(elevators, system)
  def init(elevNum: Int): Either[ElevatorServiceException, ElevatorsQueueService] = {
    if (elevNum <= 0){
      Left(ElevatorServiceException("There is no possibility of system with 0 or negative number of elevators !"))
    } else {
      val initOrders = Map((1 to elevNum).map(n => (n,List())):_*)
      Right(ElevatorsQueueService(initOrders, ElevatorSystem()))
    }
  }
}
