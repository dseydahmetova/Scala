// Add necessary Akka imports
import akka.actor.{Actor, ActorSystem, Props}

// Define the messages that the Actor can handle
case class DrawShape(shape: Shape)
case object Exit

object ShapeDrawingActor {
  def props: Props = Props(new ShapeDrawingActor)
}

class ShapeDrawingActor extends Actor {
  def receive: Receive = {
    case DrawShape(shape) => shape.draw()
    case Exit =>
      println("Exiting...")
      context.system.terminate()
    case x => println("Error: Unknown message! " + x)
  }
}

// Define the shapes as before
class Point(val x: Double, val y: Double) {
  override def toString() = "Point(" + x + ", " + y + ")"
}

abstract class Shape {
  def draw(): Unit
}

class Circle(val center: Point, val radius: Double) extends Shape {
  def draw() = println("Circle.draw: " + this)
  override def toString() = "Circle(" + center + ", " + radius + ")"
}

class Rectangle(val lowerLeft: Point, val height: Double, val width: Double) extends Shape {
  def draw() = println("Rectangle.draw: " + this)
  override def toString() = "Rectangle(" + lowerLeft + ", " + height + ", " + width + ")"
}

class Triangle(val point1: Point, val point2: Point, val point3: Point) extends Shape {
  def draw() = println("Triangle.draw: " + this)
  override def toString() = "Triangle(" + point1 + ", " + point2 + ", " + point3 + ")"
}

// Define the application entry point
object ShapeDrawingApp extends App {
  val system = ActorSystem("ShapeDrawingSystem")
  val shapeDrawingActor = system.actorOf(ShapeDrawingActor.props, "shapeDrawingActor")

  shapeDrawingActor ! DrawShape(new Circle(new Point(0.0, 0.0), 1.0))
  shapeDrawingActor ! DrawShape(new Rectangle(new Point(0.0, 0.0), 2, 5))
  shapeDrawingActor ! DrawShape(new Triangle(new Point(0.0, 0.0), new Point(1.0, 0.0), new Point(0.0, 1.0)))
  shapeDrawingActor ! 3.14159
  shapeDrawingActor ! Exit
}
