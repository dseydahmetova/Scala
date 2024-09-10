import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps
case class Calc()


sealed trait Expr

case class Number(value: Int) extends Expr
case class Plus(lhs: Expr, rhs: Expr) extends Expr
case class Minus(lhs: Expr, rhs: Expr) extends Expr

//def value(expression: Expr): Int - expression match{
//  case Number(value) => value
//  case Plus(lhs, rhs) => value(lhs) + value(rhs)
//  case Minus(lhs, rhs) => value(lhs) - value(rhs)
//}
//val result = value(Plus(Number(2), Number(2)))





