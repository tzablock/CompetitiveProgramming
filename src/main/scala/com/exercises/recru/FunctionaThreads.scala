package com.exercises.recru

import java.util.concurrent.{ExecutorService, TimeUnit}

object FunctionaThreads {
  type Par[A] = ExecutorService => java.util.concurrent.Future[A]
  type SomeType = String => Unit


  def run[A](es: ExecutorService)(par: Par[A]): java.util.concurrent.Future[A] = par(es)

  def unti[A](a: A): Par[A] = _ => UnitFuture(a)
  private case class UnitFuture[A](get: A) extends java.util.concurrent.Future[A] {
    override def cancel(mayInterruptIfRunning: Boolean): Boolean = false

    override def isCancelled: Boolean = false

    override def isDone: Boolean = true

    override def get(timeout: Long, unit: TimeUnit): A = get
  }

}
