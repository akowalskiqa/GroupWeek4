import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 20/06/2017.
  */
class FloorStaffTest extends FlatSpec {
  " As an Employee I wish to open the shop to tally a day's profit" should "Employee open the shop" in {
    val shop = new Shop
    val employee = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)

    employee.openShop(shop,employee)
    assert(shop.openStatus)
  }
  it should "open the days tally counter at start of 0" in{
    val shop = new Shop
    val employee = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)
    employee.openShop(shop,employee)
    assert(shop.todaysIncomeTally == 0)
  }


  "As an Employee I want to sell Product/Products to customer" should "sell item(-1 from stock amount)" in{
    //listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord
    val shop = new Shop
    val money = shop.todaysIncomeTally
    val employee = shop.defineAnPersonType(PersonType.FloorStaff, "John", shop.idGenerator.uniqueEmployeeId)

    var item1 = shop.defineAnItem(ItemTypes.Misc, "Monsters Inc",2.50, 5)
    var item2 = shop.defineAnItem(ItemTypes.Misc, "Terminator",2.50, 5)
    var item3 = shop.defineAnItem(ItemTypes.Game, "Halo",2.50, 5)

    val itemList = new ArrayBuffer[Item]()

    itemList+= item1
    itemList+= item2
    itemList+= item3
    val array = itemList.toArray

    var customer = shop.defineAnPersonType(PersonType.Customer, "Fred", shop.idGenerator.uniqueCustomerId)
    //var customer = new Customer("Fred", 3245, true, 10, ArrayBuffer[Item](),ArrayBuffer[Int]())
    var summarySale = new SummarySaleRecord ()
    var stock = new Stock

    stock.updateStockForID(1234,50)


    shop.sellThis(array, customer, stock, employee, summarySale)
    //employee.sellItem(array, customer, shop, stock, employee, summarySale)

    assert(stock.getAmountOfProductsForThisID(1234) == 47)
    assert(shop.todaysIncomeTally > money)
    //assert(employee.getItemStockQuanitity() == stock.)
  }


}