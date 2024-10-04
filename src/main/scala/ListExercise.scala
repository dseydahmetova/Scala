object ListExercise {
    def main(args: Array[String]): Unit = {
      val fruit = List("apples", "oranges", "pears")
      val nums = List(1, 2, 3, 4)
      val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
      val empty = List()
      val heterogeneousList: List[Any] = List(1, "1", '1')
      
      println("fruit: " + fruit)
      println("nums: " + nums)
      println("diag3: " + diag3)
      println("empty: " + empty)
      println("heterogeneousList (List(1, \"1\", '1')): " + heterogeneousList)


      val fruit1: List[String] = List("apples", "oranges", "pears")
      val nums1: List[Int] = List(1, 2, 3, 4)
      val diag31: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
      val empty1: List[Nothing] = List()
      
      
//      Constructors of Lists
// all lists are constructed from:
//the empty list Nil, and
//the construction operation :: (pronounced cons): 
// x :: xs gives a new list with the first element x, 
// followed by the elements of xs (which is a list itself).
      val fruit2 = "apples" :: ("oranges" :: ("pears" :: Nil))
      val nums2 = 1 :: (2 :: (3 :: (4 :: Nil)))
      val empty2 = Nil
      
      
//      val nums = 1 :: 2 :: 3 :: 4 :: Nil
//      expression above is equivalent to:
//
//      val nums = Nil.::(4).::(3).::(2).::(1)


//      nums match {
//        // Lists of `Int` that starts with `1` and then `2`
//        case 1 :: 2 :: xs =>…
//        // Lists of length 1
//        case x :: Nil =>…
//        // Same as `x :: Nil`
//        case List(x) =>…
//        // The empty list, same as `Nil`
//        case List() =>
//        // A list that contains as only element another list that starts with `2`
//        case List(2 :: xs) =>…
//      }



//      Exercise: Sorting Lists in ascending order:
//      One way to sort the list List(7, 3, 9, 2) is to sort the tail List(3, 9, 2) to obtain List (2, 3, 9).
//        The next step is to insert the head 7 in the right place to obtain the result List (2, 3, 7, 9).
//        This idea describes Insertion Sort:

//      def insertionSort(xs: List[Int]): List[Int] = xs match {
//        case List() => List()
//        case y :: ys => insert(y, insertionSort(ys))
//      }

      //      1 :: 3 :: Nil is equivalent to the list List(1, 3).
     
      val cond: (Int, Int) => Boolean = (x, y) => x < y
      def insert(x: Int, xs: List[Int]): List[Int] =
        xs match {
          case List() => x :: Nil
//         second call:  y = 3 and ys = List().
          case y :: ys =>
//            x is inserted before y, 
            //  Since cond(2, 1) is always false (because cond is false), 
            //  the function proceeds to the else part and makes a recursive call:
            if (cond(x, y)) x :: y :: ys
//              insert(2, List(3))
            else y :: insert(x, ys)
        }
       println("insert(2, 1 :: 3 :: Nil): " + insert(2, 1 :: 3 :: Nil))
       println("insert(1, 2 :: 3 :: Nil): " + insert(1, 2 :: 3 :: Nil))
       println("insert(3, 1 :: 2 :: Nil): " + insert(3, 1 :: 2 :: Nil))


//      Transform the elements of a list using map :
        List(1, 2, 3).map(x => x + 1) == List(2, 3, 4)
//      Filter elements using filter :
        List(1, 2, 3).filter(x => x % 2 == 0) == List(2)


      //  Transform each element of a list into a list and 
      //  flatten the results into a single list using flatMap:
      val xs = List(1, 2, 3).flatMap {
        x => List(x, 2 * x, 3 * x)
      }
      //  xs == List(1, 2, 3, 2, 4, 6, 3, 6, 9)
      println("xs: " + xs)

      def foo(x: Double): String =
        sqrt(x) match {
          case None => "no result"
          case Some(y) => y.toString
        }

      
//    Common Operations on Options
      Some(1).map(x => x + 1) shouldBe Some(2)
      None.map((x: Int) => x + 1) shouldBe None
      Some(2).map(x => x + 1) shouldBe  Some(3)
      
      
//      Error Handling
//Try[A] represents a computation that attempted to return an A. It can either be:
      //a Success[A],
      //or a Failure.
// Try[A] also have map, filter and flatMap.
      //def sqrt(x: Double): Try[Double] =
      //  if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
      //  else Success(…)


      // Either
      //Either can also be useful to handle failures. Basically, the type Either[A, B] 
      // represents a value that can either be of type A or of type B.
//      def sqrt(x: Double): Either[String, Double] =
//        if (x < 0) Left("x must be positive")
//        else Right(…)

      Right(1).map((x: Int) => x + 1) shouldBe Right(2)
      Left("foo").map((x: Int) => x + 1) shouldBe Left("foo")
      Right(1).filterOrElse(x => x % 2 == 0, "Odd value") shouldBe Left("Odd value")

      def triple(x: Int): Int = 3 * x
      def tripleEither(x: Either[String, Int]): Either[String, Int] =
        x.map(triple)

      tripleEither(Right(1)) shouldBe Right(3)
      tripleEither(Left("not a number")) shouldBe Left("not a number")


    }



}

