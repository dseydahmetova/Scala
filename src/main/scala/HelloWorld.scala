import scala.collection.mutable.ArrayBuffer
import scala.util.{Random, Try}

object HelloWorld {
  def computeMessage(): String = {
    "0"
  }
  def computeNumber(x: Int) = {
    if (x>= 0) {
      x
    } else {
      -x
    }
  }

  def main(args: Array[String]): Unit = {
    val message = computeMessage()
    val number = computeNumber(5)
    println("\nMessage: " + message + " Number: "+ number)

    val calculations = someCalc(18)
  }

  def someCalc(x: Int) = {
    val ageGroup = if (x >= 18) "grownup" else "minor"
    println("\nIf statement for age " + x  + ": " + ageGroup)

    val someValue: Int = {
      val one = 1
      val two = 2
      one * two
    }
    println("\nMultiplication: " + someValue)
  }

//  def square(x: Int) = x * x
//val f: [Int -> Int] = square

  println("\nWhile loop:")
  var a: Int = 0
  while (a < 10) {
    a += 1
    println(a)
  }

  println("\nFor loop:")
  for (i <- 1 to 10) {
    println(i)
  }

  println("\nFor loop with vector:")
  val v = Vector(1, 2, 3, 4)
  for (i <- v) {
    println(i)
  }
  val (firstPart, secondPart) = v.splitAt(v.length / 2)
  println("First: " + firstPart + ", Second: " + secondPart)
  println("Vector elements that are > 2: ")
  val r: Option[Int] = v.find(x => x > 2)
  // option 1
  if(r.isDefined){
    println("Option1: " + r.get)
  } else println("Option1: None")
  // option 2
  println("Option2: " + r )

  // option 3
  r match {
    case Some(k) => println("Option3: " + k)
    case None => println("Option3: None")
  }
  // option 4
  println("Option4: " + r.getOrElse("None"))


  println("\nFor loop with Yield:")
  println(for (v <- 1 until 10) yield v * v)

  println("\nTuples:")
  val pair: (Int, Int) = (1, 2)
  val tuple: (Int, String) = (1, "Cake")
  //  val pair2 = "key" -> "value"
  val pair1 = pair._1
  val pair2 = pair._2
  val (first, second) = tuple
  println("Pair1: " + pair1 + ", Pair2: " + pair2)
  println("First: " + first + ", Second: " + second)


  val buffer = ArrayBuffer[Int](12, 24, 31)
  buffer += 4
  val third = buffer(2)
  println("\nArray: " + buffer + ", Third element: " + third)
  //  buffer.get(i)
  val f: (Int => Int) = buffer
  println("F: " + f)


  val address = Address("email", "helllo@g.com")
  val Address(_, email) = address
  println("\nClass: " + address)


  // Pat tern matching
//  sealed trait Expr
//  case class Number(value: Int) extends Expr
//  case class Plus(lhs: Expr, rhs: Expr) extends Expr
//  case class Minus(lhs: Expr, rhs: Expr) extends Expr

// The right way to write
sealed trait Expr extends Product with Serializable
final case class Number(value: Int) extends Expr
final case class Plus(lhs: Expr, rhs: Expr) extends Expr
final case class Minus(lhs: Expr, rhs: Expr) extends Expr

  def value(expression: Expr): Int = expression match {
    case Number(value) => value
    case Plus(lhs, rhs) => value(lhs) + value(rhs)
    case Minus(lhs, rhs) => value(lhs) - value(rhs)
  }
  val result = value(Plus(Number(2), Number(3)))
  println("\nCalculator: 2 + 3 = " + result)


  println("\nException for 1/0 => ")
  try{
    1/0
  } catch {
    case ex: ArithmeticException =>
      println("\nOption1: " + ex.getMessage)
  }

  val exceptionResult: Try[Int] = Try{
    1/0
  }
  println("Option2: " + exceptionResult)


  val vec = Vector.fill(10){
    Try{
      1/Random.nextInt(5)
    }
  }

  println(" 1/Random(5) count success cases: " + vec.count(x => x.isSuccess))
  for (i <- vec) {
    println(i)
  }
}
