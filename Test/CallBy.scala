//Creates an object that extends App
object CallBy extends App {

  val count = 0

  /**
   * Necessary to increment the value. Scala
   * devs did not want increment and decrement
   * operators to maintain the functional
   * language properties
   *
   * @return
   */
  def incrementValue(): Int = {
    count += 1
    count //Returns the value
  }

  def callByValue(arg: Int): Unit = {

  }

  def callByName(arg: => Int): Unit = {

  }

}