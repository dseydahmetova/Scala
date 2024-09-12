package Restaurant
import Restaurant.*

object myRestaurant {
  def main(args: Array[String]): Unit = {

    //Food <- Meat
    val beef = new Meat("beef")
    //Food <- Meat <- WhiteMeat
    val chicken = new WhiteMeat("chicken")
    val turkey = new WhiteMeat("turkey")
    //Food <- Vegetable
    val carrot = new Vegetable("carrot")
    val pumpkin = new Vegetable("pumpkin")

    //Recipes
    val mixRecipe = new GenericRecipe(List(chicken, carrot, beef, pumpkin))
    val meatRecipe = new MeatRecipe(List(beef, turkey))
    val whiteMeatRecipe = new WhiteMeatRecipe(List(chicken, turkey))


    // Chefs
    val giuseppe = new WhiteMeatChef
    val giuseppeResult = giuseppe.cook(whiteMeatRecipe)
    println(s"Giuseppe is a ${giuseppe.specialization} chef.")
    println(s"Trying to cook ${whiteMeatRecipe.name}")
    println(giuseppeResult)


    val alfredo = new MeatChef
    val alfredoResult1 = alfredo.cook(meatRecipe)
    val alfredoResult2 = alfredo.cook(whiteMeatRecipe)
    println(s"\nAlfredo is a ${alfredo.specialization} chef.")
    println(s"Trying to cook ${meatRecipe.name} and ${whiteMeatRecipe.name}")
    println(alfredoResult1)
    println(alfredoResult2)


    val mario = new GenericChef
    mario.cook(mixRecipe)
    mario.cook(meatRecipe)
    mario.cook(whiteMeatRecipe)
    val marioResult1 = mario.cook(mixRecipe)
    val marioResult2 = mario.cook(meatRecipe)
    val marioResult3 = mario.cook(whiteMeatRecipe)
    println(s"\nMario is a ${mario.specialization} chef.")
    println(s"Trying to cook ${mixRecipe.name} and ${meatRecipe.name} and ${whiteMeatRecipe.name}")
    println(marioResult1)
    println(marioResult2)
    println(marioResult3)


    //Restaurants
    val allFood = new GenericRestaurant(List(mixRecipe), mario)
    val foodParadise = new GenericRestaurant(List(meatRecipe), mario)
    val superFood = new GenericRestaurant(List(whiteMeatRecipe), mario)

    val meat4All = new MeatRestaurant(List(meatRecipe), alfredo)
    val meetMyMeat = new MeatRestaurant(List(whiteMeatRecipe), mario)

    val notOnlyChicken = new WhiteMeatRestaurant(List(whiteMeatRecipe), giuseppe)
    val whiteIsGood = new WhiteMeatRestaurant(List(whiteMeatRecipe), alfredo)
    val wingsLovers = new WhiteMeatRestaurant(List(whiteMeatRecipe), mario)
    println(s"\nThe restaurant menu is: ${allFood.cookMenu} and chef is: ${allFood.chef.specialization}")
    println(s"The restaurant menu is: ${meat4All.cookMenu} and chef is: ${meat4All.chef.specialization}")
    println(s"The restaurant menu is: ${whiteIsGood.cookMenu} and chef is: ${whiteIsGood.chef.specialization}")

  }
}