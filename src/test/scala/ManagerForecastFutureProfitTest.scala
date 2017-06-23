import org.scalatest.FlatSpec
import java.util.Date

/**
  * Created by Profile on 22/06/2017.
  */
class ManagerForecastFutureProfitTest extends FlatSpec{

  "As a manager I" can "forecast future profits" in{

    var shop = new Shop()
    var sale = new SummarySaleRecord()
    shop.openShop()

    sale.datesIncome.put(new Date("Fri Oct 31 15:07:24 2014"), 20.23)
    sale.datesIncome.put(new Date("Fri Oct 21 15:07:24 2014"), 106.50)
    sale.datesIncome.put(new Date("Fri Oct 11 15:07:24 2014"), 36.10)
    sale.datesIncome.put(new Date("Fri Oct 30 15:07:24 2014"), 87.35)
    sale.datesIncome.put(new Date("Fri Oct 25 15:07:24 2014"), 40.75)
    sale.datesIncome.put(new Date("Fri Oct 24 15:07:24 2014"), 50.05)

    val profit  = sale.getPredictedIncomeForTomorrowBasedOnHistoryProvided()
    val predProfit: String = f"£$profit%2.2f"

    assert(predProfit == "£56.83")

  }

}
