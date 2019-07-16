package com.exercises.spoj.scala.TransformTheExpression


object Main extends App {
  val t = scala.io.StdIn.readInt()
  (1 to t).map( i => {
    val exp = scala.io.StdIn.readLine()
    transformExpr(exp)
  }).foreach(println)

  def transformExpr(expr: String): String = {
    def recExprTr(expr: String, stock: String, res: String): String = {
      if (expr.isEmpty){
        res
      } else {
        val signRgx = "([a-z])".r
        val opRgx = "([^a-z])".r
        val (s,r) = expr.head match {
          case '(' => (stock, res)
          case ')' => (stock.tail, res + stock.head)
          case signRgx(s) => (stock, res + s)
          case opRgx(o) => (o + stock, res)
        }
        recExprTr(
          expr.tail,
          s,
          r
        )
      }
    }
    recExprTr(expr, "", "")
  }
}
