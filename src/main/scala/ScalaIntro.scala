object ScalaIntro {
  def main(args: Array[String]): Unit = {
    println("Scala introduction:")
    println("\n---------------------------LOOP----------------------------------")

// Immutable variables using val
    val name1 = "Artur"
// Mutable variables  using var
    var name2 = "Queen"

    def drawSword(): Unit = {
      // if-else
      if(name1.contains("Artur"))
        println("Entombed sword")
      else
      {
        println("You're not entitled to this sword")
      }
    }

//      while
    var attempts = 0
    while (attempts < 3) {
      drawSword()
      attempts += 1
    }


    //     Collections
    println("\n-----------------------------COLLECTIONS---------------------------------")
val names = List("Arthur", "Uther", "Mordred", "Vortigern")
    println(names)
    println("first element using head: " + names.head)
// a list using the cons :: operator
val name = "Dan" :: "Bob" :: "Mike" :: "Tom" :: Nil
    println(name)
    println("2nd element using index: " + name(2))
val namel = "Liza" :: ("Ann" :: ("Molly" :: ("Victoria" :: Nil)))
    println(namel)
    println("Last elements using tail: " + namel.tail)


    //    Set - a non-repeated group of entities
    //    List doesn’t eliminate duplicates by default.
    println("\n-----------------------------SET-------------------------")
    val nameswithDuplicates = List("Arthur", "Uther", "Mordred", "Vortigern", "Arthur", "Uther")
    println("Duplicate names: " + nameswithDuplicates)
    val uniqueNames = Set("Arthur", "Uther", "Mordred", "Vortigern", "Arthur", "Uther")
    println("Duplicate names removed: " + uniqueNames)
    //  existence of specific element in Set using contains()
    println("Contains Vortigern: " + uniqueNames.contains("Vortigern"))
    //    add elements to a Set using the + method
    val uniqueNamesExtend = uniqueNames + ("Igraine", "Elsa", "Guenevere")
    println("Adding elements using '+': " + uniqueNamesExtend)
    //    remove elements using the - method
    val uniqueNamesReduce = uniqueNamesExtend - "Elsa"
    println("Removing Elsa using '-': " + uniqueNamesReduce)

    println("\n-----------------------------MAP---------------------------")
    val kingSpouses = Map("King Uther" -> "Igraine", "Vortigern" -> "Elsa", "King Arthur" -> "Guenevere" )
    println(kingSpouses)
    // Values for a specific key in map can be accessed as:
    println("Value for Vortigern: " + kingSpouses("Vortigern"))
    //add an entry to Map using the + method:
    val addToMap = kingSpouses + ("Launcelot" -> "Elaine")
    println("adding Launcelot: " + addToMap)
    //To modify an existing mapping, we simply re-add the updated key-value:
    val updateMap = kingSpouses + ("Launcelot" -> "Guenevere")
    println("updating Launcelot: " + updateMap)
    //    Note that since the collection is immutable,
    //    each edit operation returns a new collection( res0, res1) with the changes applied.

    println("\n--------------------------Functional combinators---------------------------")
//    we want to find names of all queens using the kingSpouses using the filter combinator on map
// collection.filter( /* a filter condition method which returns true on matching map entries */)
    def isKingly(key_value: (String, String))
    : Boolean = key_value._1.toLowerCase().contains("king")

    val kingsAndQueens = kingSpouses.filter(isKingly)
    println("Keys include 'king': " + kingsAndQueens)
    println("Queens': " + kingsAndQueens.values)
    kingsAndQueens.values.foreach(println)


  }
}
