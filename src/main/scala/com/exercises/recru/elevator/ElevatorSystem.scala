package com.exercises.recru.elevator

class ElevatorSystem() {
  def updateOrders(elevatorNum: Int, floor: Int): ElevatorSystem = {
    println(s"Add to elevator number ${elevatorNum} queue floor number ${floor}")
    this
  }

  def ifElevatorCome(floor: Int, elevatorOrders: List[Int]): (Boolean, ElevatorSystem) = {
    //normaly should be sensor
    val ifElevetorCome = elevatorOrders.head == floor
    if (ifElevetorCome){
      println(s"Elevator come into floor number ${floor}")
      (ifElevetorCome, this)
    } else {
      println(s"Elevator not come yet into floor number ${floor}")
      (ifElevetorCome, this)
    }
  }
}
object ElevatorSystem {
  def apply(): ElevatorSystem = new ElevatorSystem()
}
