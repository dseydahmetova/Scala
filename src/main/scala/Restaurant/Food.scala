package Restaurant

trait Food {
  def name: String
}

class Meat(val name: String) extends Food
class Vegetable(val name: String) extends Food
class WhiteMeat(override val name: String) extends Meat(name)




