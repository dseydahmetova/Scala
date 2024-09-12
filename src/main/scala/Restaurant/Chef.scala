package Restaurant

trait Chef[-A] {
  val specialization: String
  def cook(recipe: Recipe[A]): String
}

class GenericChef extends Chef[Food] {
  val specialization = "All food"
  override def cook(recipe: Recipe[Food]): String = s"I made a ${recipe.name}"
}

class MeatChef extends Chef[Meat] {
  val specialization = "Meat"
  override def cook(recipe: Recipe[Meat]): String = s"I made a ${recipe.name}"
}

class WhiteMeatChef extends Chef[WhiteMeat]
{
  val specialization = "White meat"
  override def cook(recipe: Recipe[WhiteMeat]): String = s"I made a ${recipe.name}"
}


