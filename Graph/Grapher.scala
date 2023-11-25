//  *** NEED TO SET UP BUILD.SBT AND PLOTLY CREDENTIALS BEFORE UNCOMMENTING ***
// import co.theasi.plotly

/*
    This class will retrieve information from Parser.scala, and
    use it to create a graph with Plotly. This graph will be exported
    and displayed on the website.
*/
class Grapher (var date: Array[String], var value: Array[Double]) {

    def Graph (): Unit = {

        // val retGraph = Plot().withScatter(date, value)
        // draw(retGraph, "stock-graph", writer.FileOptions(overwrite=true))

    }

}

def main (args: Array[String]): Unit = {
    
    // temp values to see if the graph is correct
    val testDate: Array[String] = Array("Nov 21, 2018", "Nov 23, 2018",
                                    "Nov 26, 2018", "Nov 27, 2018")
    val testValue: Array[Double] = Array(2670.73, 2647.55,
                                    2674.35, 2682.53)

    val graph = new Grapher(testDate, testValue)

    graph.Graph();

}