// Program 22 : Case Classes in Scala

// Define the case class Person
case class Person(name: String, age: Int, city: String)

object Program22_CaseClasses {

  // Filter out people older than 30
  def filterOlderThan30(people: List[Person]): List[Person] =
    people.filter(p => p.age > 30)

  // Group people by their city
  def groupByCity(people: List[Person]): Map[String, List[Person]] =
    people.groupBy(_.city)

  // Transform each Person into a descriptive string
  def describe(people: List[Person]): List[String] =
    people.map(p => s"${p.name} is ${p.age} years old and lives in ${p.city}")

  // Sort people by age in ascending order
  def sortByAge(people: List[Person]): List[Person] =
       people.sortBy(_.age)

  def main(args: Array[String]): Unit = {

    // Create a list of five Person objects
    val people = List(
      Person("Naveen", 23, "Vellore"),
      Person("Anil",   35, "Chennai"),
      Person("Pavan",  28, "Vellore"),
      Person("Hanif",  41, "Hyderabad"),
      Person("Ram",    32, "Chennai")
    )
    println("List of Persons:")
    people.foreach(p => println("  " + p))

    println("\nPeople older than 30:")
    filterOlderThan30(people).foreach(p => println("  " + p))

    println("\nPeople grouped by city:")
    groupByCity(people).toSeq.sortBy(_._1).foreach { case (city, ps) =>
      println("  " + city + " -> " + ps.map(_.name).mkString(", "))
    }

    println("\nDescriptions:")
    describe(people).foreach(s => println("  " + s))

    println("\nSorted by age (ascending):")
    sortByAge(people).foreach(p => println("  " + p))
  }
}
