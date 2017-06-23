
/**
  * Created by Administrator on 20/06/2017.
  */

object Main {


  def main(args: Array[String]) = {
    var shop = new Shop // should have been "new Shop(stock,summarySaleRecord)" something like that, but discovered it too late
    var saleSum = new SummarySaleRecord
    var personLoggedIn: FloorStaff = null
    var stock = new Stock
    var cashValue: Double = 0

    var currentLoggedInEmployee = new FloorStaff("john", 1)
    currentLoggedInEmployee.openShop(shop)
    //initialise some dummy data
    saleSum.updateDatesIncome(new java.util.Date("Fri Jan 20 15:07:24 2017"), 1243.76)
    saleSum.updateDatesIncome(new java.util.Date("Fri Feb 21 15:07:24 2016"), 1713.53)

  }
}
