import scala.annotation.tailrec

def functorial(m: Int):Int = {
  @tailrec
  def fun(n: Int, r: Int): Int = {
    if (n == 1){
      r
    } else {
      fun(n-1, n*r)
    }
  }
  fun(m,1)
}

functorial(5)
// 0 1 1 2
def fibbonachi(n: Int):Int = {
  @tailrec
  def finCalc(n: Int, prevPrevNum: Int, prevNum: Int): Int = {
    if (n == 0) {
      prevNum
    } else {
      finCalc(n-1, prevNum, prevPrevNum + prevNum)
    }
  }
  if (n == 1){
    0
  } else if (n == 2){
    1
  } else {
    finCalc(n-2, 0, 1)
  }
}

fibbonachi(1)
fibbonachi(2)
fibbonachi(3)
fibbonachi(10)

def revString(s: String): String = {
  @tailrec
  def rs( s: String, revs: String): String = {
    if (s.isEmpty){
      revs
    } else {
      rs(s.tail, s.head + revs)
    }
  }
  rs(s, "")
}

revString("abcde")

def quickSort(l: List[Int]): List[Int] = {
  if(l.size <= 1) {
    l
  } else {
    val firstEl = l.head
    quickSort(l.tail.filter(_ <= firstEl)) ++ List(firstEl) ++ quickSort(l.tail.filter(_ > firstEl))
  }
}

quickSort(List(13,6,3,2,7,2,9,1))