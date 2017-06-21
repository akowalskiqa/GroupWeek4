import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 20/06/2017.
  */
class FloorStaffTest extends FlatSpec {
  " As an Employee I wish to open the shop to tally a day's profit" should "Employee open the shop" in {
    val employee = new FloorStaff("john",1,1)
    val shop = new Shop
    employee.openShop(shop)
    assert(shop.openStatus == true)
  }
  it should "open the days tally counter at start of 0" in{
    val employee = new FloorStaff("john",1,1)
    val shop = new Shop
    employee.openShop(shop)
    assert(shop.todaysIncomeTally == 0)
  }


  "As an Employee I want to sell Product/Products to customer" should "sell item(-1 from stock amount) and allocate receipt corresponding to SaleRecord for the customer" in{
    //listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord
    val employee = new FloorStaff("john",1,1)
    var shop = new Shop
    employee.openShop(shop)
    val dvd0 = new Misc(1234, "Monsters Inc",2.50, 5)
    val dvd1 = new Misc(1234, "Monsters Inc",2.50, 5)
    val dvd2 = new Misc(1234, "Monsters Inc",2.50, 5)
    val itemList = new ArrayBuffer[Item]()
    itemList+= dvd0
    itemList+= dvd1
    itemList+= dvd2
    val array = itemList.toArray

    var customer = new Customer("Fred", 3245, true, 10, ArrayBuffer[Item](),ArrayBuffer[Int]())
    var summarySale = new SummarySaleRecord ()
    var stock = new Stock
    stock.updateStockForID(1234,50)
    employee.sellItem(array, customer, shop, stock, employee, summarySale)
    assert(stock.getAmountOfProductsForThisID(1234)==47)
    assert(customer.receivedReceiptsIDs(0) == summarySale.getSaleRecord(0).getReciptId())

    //assert(employee.getItemStockQuanitity() == stock.)
  }


}