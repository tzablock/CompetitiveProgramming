package com.exercises.recru.elevator

sealed trait ElevatorException
case class ElevatorServiceException(message: String)
