package scala

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.FileWriter
import scala.collection.immutable.Seq
import scala.collection.JavaConverters.*
import java.io.{File, PrintWriter}

object Scraper {

  //Fetches the URL
  def fetchPage(url: String): String = {
    Jsoup.connect(url).get().html()
  }

  //Parse the html
  def parseHtml(html: String): Seq[StockData] = {
    val document: Document = Jsoup.parse(html)
    val rows = document.select("table > tbody > tr").asScala

    val data = rows.flatMap { row => val cols = row.select("td").asScala.map(_.text.replace(",", ""))
      if (cols.size >= 6) {
        Some(StockData(
          date = cols.head,
          open = cols(1).toDouble,
          high = cols(2).toDouble,
          low = cols(3).toDouble,
          close = cols(4).toDouble,
          adjClose = cols(5).toDouble,
          volume = cols(6).replace(",", "")
        ))
      } else None
    }
      //Converts data to a sequence
      data.toSeq
  }

  def writeToFile(fileName: String, data: Seq[StockData]): Unit = {
    var writer: PrintWriter = null

    try {
      writer = new PrintWriter(new FileWriter(fileName, true))
      writer.write("Date\t\t\tOpen\tHigh\tLow\tClose\tAdj Close\tVolume\n")
      data.foreach(StockData => writer.write(StockData.fileString + "\n"))
    }
    finally {
      if (writer != null) {
        writer.close()
      }
    }
  }

  //Creates a case class
  case class StockData(date: String, open: Double, high: Double, low: Double, close: Double, adjClose: Double, volume: String) {

    override def toString: String = {
      s"Date: $date, Open: $open, High: $high, Low: $low, Close: $close, Adj Close: $adjClose, Volume: $volume"
    }

    def fileString: String = {
      s"$date\t\t$open\t\t$high\t\t$low\t\t$close\t\t$adjClose\t\t$volume"
    }
  }
}