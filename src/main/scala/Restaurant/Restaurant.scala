package Restaurant

trait Restaurant [A]{
  def menu: List[Recipe[A]]
  def chef: Chef[A]
  def cookMenu: List[String] = menu.map(chef.cook)
}

case class GenericRestaurant(menu: List[Recipe[Food]], chef: Chef[Food]) extends Restaurant[Food]
case class MeatRestaurant(menu: List[Recipe[Meat]], chef: Chef[Meat]) extends Restaurant[Meat]
case class WhiteMeatRestaurant(menu: List[Recipe[WhiteMeat]], chef: Chef[WhiteMeat]) extends Restaurant[WhiteMeat]

