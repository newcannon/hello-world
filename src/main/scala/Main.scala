object Main extends App {
  println("Hello, World!")
  def failingFn(i: Int): Int = {
    println("start, failingFn!")
    val y: Int = throw new Exception("fail!")
    try {
      val x = 42 + 5
      x + y
    } catch {
      case e: Exception => 43
    }
  }
  def failingFn2(i: Int): Int = {
    println("start, failingFn2!")
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int)
    } catch {
      case e: Exception => 43
    }
  }

  def mean(xs: Seq[Double]): Double = {
    if (xs.isEmpty) {
      throw new ArithmeticException("mean of empty list!")
    } else {
      xs.sum / xs.length
    }
  }

  def mean2(xs: Seq[Double], onEmpty: Double): Double = {
    if (xs.isEmpty) { onEmpty }
    else { xs.sum / xs.length }
  }

  def mean3(xs: Seq[Double]): Option[Double] = {
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
  }
  // val x2 = failingFn2(12)
  // println(x2)
  val nums: List[Double] = List(1.0, 2.0, 3.0, 4.0)
  val nums2: List[Double] = List()
  val m3 = mean3(nums)

  println(m3)
  val m4 = mean3(nums2)
  println(m4)

  val x: Either[String, Int] = Right(7)
  val result1 = for (res <- x.right) { res }
  val result2 = for (res <- x.left) { res }

}
