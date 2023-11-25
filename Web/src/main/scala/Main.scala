import scala.Scraper.StockData

object Main {

  def main(args: Array[String]): Unit = {
    val yahooFinanceUrl = "https://finance.yahoo.com/quote/%5EIXIC/history?p=%5EIXIC"
    val htmlContent = Scraper.fetchPage(yahooFinanceUrl)
    var historicalData: Seq[Scraper.StockData] = Scraper.parseHtml(htmlContent)
    historicalData = historicalData.reverse
    var dates: Seq[String] = historicalData.map(StockData => StockData.date)
    var close: Seq[Double] = historicalData.map(StockData => StockData.close)
    //historicalData.foreach(println)
    //var test: Seq[Scraper.DataPoint] = Scraper.parseHtml(htmlContent)
    dates.foreach(println)
    close.foreach(println)
  }
}
