package com.exercises.recru


import java.util.concurrent.{Callable, ExecutorService, Executors, TimeUnit}


import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.io.Source
import scala.util.{Failure, Success}

object Threads {
  def main(args: Array[String]): Unit = {
    for (i <- Range(0, 10)) {
      val thr = new Thread {
        override def run(): Unit = {
          println(s"Thread number $i work.")
        }
      }
      thr.start()
      new Thread(new MyRunnable(i)).start()
      Thread.sleep(50)
    }
  }
}

class MyRunnable(num: Int) extends Runnable {
  override def run(): Unit = {
    println(s"Thread num $num work")
  }
}

object ThreadCheck {
  def main(args: Array[String]): Unit = {
    println("aaa")
    new Thread {
      override def run(): Unit = {
        println("bbb")
        println("bbb")
        println("bbb")
      }
    }.start()
    Thread.sleep(1)
    println("aaa")
    println("aaa")
  }
}

import scala.concurrent.ExecutionContext.Implicits.global

object FutureScala {
  def main(args: Array[String]): Unit = {
    val thr =  new Thread() {
      override def run(){
        println("sss")
      }
    }
    thr.start()
    val future1: Future[String] = Future {
      Source.fromFile("/Users/tomaszzablocki/Projects/ProjectsToLearnFrom/CompetitiveProgramming/src/main/scala/com/exercises/recru/someFile").getLines().reduce((acc,l) => acc + l)
    }

    future1.onComplete {
        case Success(value) => println(value)
        case Failure(exception) => println(exception)
    }
    println("dupa")

    Await.result(future1, Duration.fromNanos(1000000000))
  }
}

object NumOfProcessors {
  def main(args: Array[String]): Unit = {
    println(Runtime.getRuntime.availableProcessors())
  }
}

object ThreadPool {
  def main(args: Array[String]): Unit = {
    val task1 = new Runnable {
      override def run(): Unit = println("a")
    }
    val task2 = new Runnable {
      override def run(): Unit = println("b")
    }
    val task3 = new Runnable {
      override def run(): Unit = println("c")
    }
    val task4 = new Runnable {
      override def run(): Unit = println("d")
    }
    val service: ExecutorService = Executors.newFixedThreadPool(4)
    service.submit(task1)
    service.submit(task2)
    service.submit(task3)
    service.submit(task4)

    val cal = new Callable[String] {
      override def call(): String = "aaaa"
    }
    val cal1 = new Callable[String] {
      override def call(): String = "bbbb"
    }

    val future: java.util.concurrent.Future[String] = service.submit(cal)
    println(future.get())
  }
}
