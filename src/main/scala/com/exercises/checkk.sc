val twoSignOneOp = "([a-z])([^a-z)(])([a-z])".r
val oneSignOneOpRight = "([a-z])([^a-z)(])".r
val oneSignOneOpLeft = "([^a-z)(])([a-z])".r
val oneSignTwoOp = "([^a-z)(])([a-z])([^a-z)(])".r
val oneOp = "([^a-z)(])".r

def creteRPNExprFromStock(stack: List[String]):String = {
  def creteStrFromStock(stack: List[String], rpnExpr: List[String], endOfBrak: Boolean): String = {
    println("STack" + stack)
    println("Exp" +
      "" + rpnExpr)
    if (stack.isEmpty) {
      rpnExpr.reduce((agg, s) => agg + s)
    } else {
      creteStrFromStock(stack.tail,
      stack.head match {
        case twoSignOneOp(s1, o, s2) =>  if(endOfBrak) s1 + s2 + o  :: rpnExpr else rpnExpr.head :: s1 + s2 + o  :: rpnExpr.tail
        case oneSignOneOpRight(s, o) => s :: rpnExpr ++ List(o)
        case oneSignOneOpLeft(o, s) => s :: rpnExpr ++ List(o)
        case oneSignTwoOp(o1, s, o2) =>  s :: rpnExpr ++ orderByPrior(o1,o2)
        case oneOp(o) => rpnExpr ++ List(o)
        case _ => rpnExpr
      }, stack.head == ")")
    }
  }
  def determinePrior(o: String): Int = {
    o match {
      case "+" =>  0
      case "-" =>  1
      case "*" =>  2
      case "/" =>  3
      case "^" =>  4
    }
  }
  def orderByPrior(o1: String, o2: String):List[String] = {
    if (determinePrior(o1) <= determinePrior(o2)){
      List(o2, o1)
    } else {
      List(o1, o2)
    }
  }
  creteStrFromStock(stack, List(), false)
}

println(creteRPNExprFromStock(List(")",")","d+e","(","-c*",")","a+b","(","(")))//((a+b)-c*(d+e))
