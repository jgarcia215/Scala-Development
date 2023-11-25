//Uses Java Files
import java.io.File
import java.util.Scanner


//Object to parse through the TSV file. Takes a string as a parameter for the file name
class Parser (var fileName: String) {
  //Initialize variables
  val file = new File(fileName)
  val scanner = new Scanner(file)
  var date: Array[String] = new Array[String](2000)
  var value: Array[Double] = new Array[Double](2000)
  var i: Int = 0

  def Parse (): Unit = {    //Subroutine that parses through the file
    scanner.nextLine() //Needed to skip the header

    //Scans through the data using java.util.scanner
    while (scanner.hasNext()) {
      //date(i) = scanner.next() + " " + scanner.next() + " " + scanner.next()
      date(i) = scanner.next()
      scanner.next()
      value(i) = scanner.nextDouble()
      scanner.nextLine()
      i += 1
    }

    scanner.close()
  }

  def Print (): Unit = {    //Prints out the contents
    for (j <- 0 until i) {
      println("Date: " + date(j) + "\tValue: " + value(j))
    }
  }
}

//Main method
def main(args: Array[String]): Unit = {
  val parse = new Parser("S&P 500 (^GSPC) -- 5 years - Sheet1.csv")
  parse.Parse()
  parse.Print()
}