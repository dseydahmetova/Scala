import scala.annotation.tailrec

object Greetings {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    //    -----------------Terms And Types ---------------
    //  Compound Expressions - Evaluation
    println(1 + 2)
    println("Hello, " ++ "Scala!")

    //  Method Calls
    println("Hello, Scala!".size)
    println(1.to(10))
    println("Hello, Scala!".toUpperCase())
    println(-42.abs)

    //  The infix syntax allows you to omit the dot and the parentheses.
    println(3 + 2 == 3.+(2))
    println(1.to(10) == (1 to 10))
    //  Values and Types - Static Typing
    //  The Scala compiler statically checks that you don’t combine incompatible expressions.

    //    The Java Integer toHexString() method returns a string representation
    //    of the integer argument as an unsigned integer in base 16.
    println("16.toHexString: " + 16.toHexString)

    // The digits in base 16 range from 0 to F, where A = 10, B = 11, ..., F = 15.
    //    The next number after F is 10 in hexadecimal, which is equivalent to 16 in decimal.

    println("(0 to 10).contains(10): " + (0 to 10).contains(10))
    println("(0 until 10).contains(10): " + (0 until 10).contains(10))

    println("foo.drop(1):" + "foo".drop(1))
    println("bar.take(2): " + "bar".take(2))

    //     ------------------------ Definitions And Evaluation --------------

    //    Methods
    def square(x: Double) = x * x

    println("Square area: " + square(3.0))

    def area(radius: Double): Double = 3.14159 * square(radius)

    println("Disc area: " + area(10))

    // Multiple Parameters
    def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
    //    Function parameters come with their type, which is given after a colon
    //    def power(x: Double, y: Int): Double = ...

    //Call-by-name and call-by-value:
    // Call-by-value has the advantage that it evaluates every function argument only once.
    //Call-by-name has the advantage that a function argument is not evaluated if the corresponding parameter is unused in the evaluation of the function body.
    def triangleArea(base: Double, height: Double): Double = base * height / 2

    println("triangleArea(3, 4): " + triangleArea(3, 4))
    println("triangleArea(5, 6): " + triangleArea(5, 6))


    //    --------------------   Functional Loops -------------------------

    def abs(x: Double) = if (x >= 0) x else -x
    // Rewrite rules for Booleans
    //    !true --> false
    //    !false --> true
    //    true && e --> e
    //    false && e --> false
    //    true || e --> true
    //    false || e --> e

    //  define a method which computes one iteration step:
    def sqrtIter(guess: Double, x: Double): Double = if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < 0.001

    def sqrt(x: Double) = sqrtIter(1.0, x)


    def factorial(n: Int): Int =
      if (n == 0) 1
      else factorial(n - 1) * n

    println("factorial(3): " + factorial(3))
    println("factorial(4): " + factorial(4))


    //    ----------------------Lexical Scopes----------------------
    val x = 0

    def f(y: Int) = y + 1

    val result = {
      val x = f(3)
      x * x
    } + x
    println("result: " + result)

    //         Top-Level Definitions"
    //object MyExecutableProgram {
    //  val myVal = …
    //  def myMethod = …
    //}

    //                Packages and Imports:
    // file foo/Baz.scala
    //    package foo
    //    object Baz {
    //      // Bar is visible because it is in the `foo` package too
    //      Bar.someMethod
    //    }


    //     --------------------Tail Recursion---------------
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    println("gcd(14, 21): " + gcd(14, 21))

    //using a @tailrec annotation:
    //@tailrec
    //def gcd(a: Int, b: Int): Int = …


    def factorial1(n: Int): Int = {
      @tailrec
      def iter(x: Int, result: Int): Int =
        if (x == 0) result
        else iter(x - 1, result * x)

      iter(n, 1)
    }

    println("factorial(3): " + factorial(3))
    println("factorial(4): " + factorial(4))

    //   ----------------Structuring Information-----------


    sealed trait Symbol
    case class Note(name: String, duration: String, octave: Int) extends Symbol
    case class Rest(duration: String) extends Symbol
    val symbol1: Symbol = Note("C", "Quarter", 3)
    val symbol2: Symbol = Rest("Whole")
    println("symbol1 and symbol2: " + symbol1 + " and " + symbol2)

    //    match expression first checks if the given Symbol is a Note,
    //    and if it is the case it extracts its fields (name, duration and octave)
    //    and evaluates the expression at the right of the arrow. Otherwise,
    //    it checks if the given Symbol is a Rest,
    //    and if it is the case it extracts its duration field,
    //    and evaluates the expression at the right of the arrow.
//    def symbolDuration(symbol: Symbol): String =
//      symbol match {
//        case Note(name, duration, octave) => duration
//        //        variable pattern
//        case Rest(duration) => duration
//      }


      def unexhaustive(): Unit = {
        sealed trait Symbol
        case class Note(name: String, duration: String, octave: Int) extends Symbol
        case class Rest(duration: String) extends Symbol

        def nonExhaustiveDuration(symbol: Symbol): String =
          symbol match {
            case Rest(duration) => duration
          }
      }

      sealed trait Duration
      case object Whole extends Duration
      case object Half extends Duration
      case object Quarter extends Duration

      def fractionOfWhole(duration: Duration): Double =
        duration match {
          case Whole => 1.0
          case Half => 0.50
          case Quarter => 0.25
        }

    println("fractionOfWhole(Half) = " + fractionOfWhole(Half))
    println("fractionOfWhole(Quarter) = " + fractionOfWhole(Quarter))


// ---------- Higher Order Functions------------
//    Take the sum of the integers between a and b :
      def sumInts(a: Int, b: Int) : Int =
        if(a > b) 0 else a + sumInts(a + 1, b)
    println("sumInts(3, 2): " + sumInts(3, 2))
    println("sumInts(1, 8): " + sumInts(1, 8))


    //    Take the sum of the cubes of all the integers between a and b:
      def cube(x: Int): Int = x * x * x

      def sumCubes(a: Int, b: Int): Int =
        if(a > b) 0 else cube(a) + sumCubes(a + 1, b)
      println("sumCubes(0, 2): " + sumCubes(0, 2))

//    Take the sum of the factorials of all the integers between a and b:
    def sumFactorials(a: Int, b: Int): Int =
      if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
    println("sumFactorials(3, 5): " + sumFactorials(3, 5))
  
  }
}
