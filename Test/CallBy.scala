//Creates an object that extends App
object CallBy extends App {

  var count = 0

  /**
   * Necessary to increment the value. Scala
   * devs did not want increment and decrement
   * operators to maintain the functional
   * language properties
   *
   * @return int
   */
  def incrementValue(): Int = {
    count += 1
    count //Returns the value
  }

  /* Call by value */
  def callByValue(arg: Int): Unit = {
    println(s"Call-by-value: Argument is evaluated before the function call. Value: $arg")
    println(s"Call-by-value: Same value is used within the function. Value: $arg")
  }

  /* Call by name */
  def callByName(arg: => Int): Unit = {
    println(s"Call-by-name: Argument is not evaluated before the function call. First use: $arg")
    println(s"Call-by-name: Argument is re-evaluated each time it's used. Second use: $arg")
  }

  println("Demonstrating Call-by-Value:")
  callByValue(incrementValue())

  println("\nDemonstrating Call-by-Name:")
  callByName(incrementValue())
}