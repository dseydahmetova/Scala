package Restaurant

trait Recipe[+A] {
  def name: String
  def ingredients: List[A]
}

case class GenericRecipe(ingredients: List[Food]) extends Recipe[Food] {
  def name: String = s"Generic resipe based on ${ingredients.map(_.name)}"
}

case class MeatRecipe(ingredients: List[Meat]) extends Recipe[Meat] {
  def name: String = s"Meat recipe based on ${ingredients.map(_.name)}"
}

case class WhiteMeatRecipe(ingredients: List[WhiteMeat]) extends Recipe[WhiteMeat] {
  def name: String = s"Meat recipe base on ${ingredients.map(_.name)}"
}

