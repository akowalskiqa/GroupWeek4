import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer
//Working!!!!!!!!!!!!!!!
/**
  * Created by Administrator on 20/06/2017.
  */
class FloorStaffTest extends FlatSpec {
  " As an Employee I wish to open the shop to tally a day's profit" should "Employee open the shop" in {
    val employee = new FloorStaff("john",1)
    val shop = new Shop
    employee.openShop(shop)
    assert(shop.openStatus == true)
  }
  it should "open the days tally counter at start of 0" in{
    val employee = new FloorStaff("john",1)
    val shop = new Shop
    employee.openShop(shop)
    assert(shop.todaysIncomeTally == 0)
  }


  "As an Employee I want to sell Product/Products to customer" should "sell item(-1 from stock amount) and allocate receipt corresponding to SaleRecord for the customer" in{
    //listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord
    var shop = new Shop()
    shop.openShop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Bonestorm", 10.0, 10)
    var shoppingList = Array(item1)
    var stockList = new Stock()
    stockList.productQuantity +=(item1.getItemID()-> 100)
    val whoInvokedThisCall = new FloorStaff("Ryan", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Richard", 1234, true, 105)
    if (whoInvokedThisCall.isInstanceOf[FloorStaff]) {

      shop.sellThis  (shoppingList, stockList)
      assert(shoppingList.exists(item => item.getItemID()== item1.getItemID()))
    }
  }

  it should "remove stock from the stock list" in{
    var shop = new Shop()
    shop.openShop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Bonestorm", 10.0, 10)
    var shoppingList = Array(item1)
    var stockList = new Stock()
    stockList.productQuantity += (item1.getItemID()-> 100)
    val productQ = stockList.productQuantity(item1.getItemID())
    val whoInvokedThisCall = new FloorStaff("Ryan", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Richard", 1234, true, 105)
    if (whoInvokedThisCall.isInstanceOf[FloorStaff]) {

      shop.sellThis  (shoppingList, stockList)
      stockList.productQuantity += (item1.getItemID() -> 99)
      assert(stockList.productQuantity(item1.getItemID()) < productQ)
    }
  }
  }