import scala.annotation.tailrec

object Functions {
  def main(args: Array[String]): Unit = {
    println("Functions:")

    //   Summing with Higher-Order Functions
    def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sum(f, a + 1, b)

    def id(x: Int): Int = x
    def sumInts(a: Int, b: Int) = sum(id, a, b)
    def sumCubes(a: Int, b: Int) = sum(cube, a, b)
    def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

    println("sum(cube, 1, 3): " + sum(cube, 1, 3))



    //  Anonymous Functions are Syntactic Sugar
    //  {def f(x1: T1, …, xn: Tn) = e; f }


    //  Summation with Anonymous Functions
    def sumIntss(a: Int, b: Int) = sum(x => x, a, b)
    def sumCubess(a: Int, b: Int) = sum(x => x * x * x, a, b)

    def sumExercise(f: Int => Int, a: Int, b: Int): Int = {
      def loop(x: Int, acc: Int): Int =
        if (x > b) acc
        else loop(x + 1, acc + f(x))
      loop(a, 0)
    }

    println("sum(x => x, 1, 10): " + sum(x => x, 1, 10))

  }

  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  //    Take the sum of the cubes of all the integers between a and b:
  def cube(x: Int): Int = x * x * x

  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0) result
      else iter(x - 1, result * x)
    iter(n, 1)
  }




}

