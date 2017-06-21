import org.scalatest.FlatSpec

/**
  * Created by Administrator on 20/06/2017.
  */
class FloorStaffTest extends FlatSpec {
  " As an Employee I wish to open the shop to tally a day's profit" should "Employee open the shop" in {
    val employee = new FloorStaff("john",1,1)
    val shop = new Shop
    employee.openShop(shop,employee)
    assert(shop.openStatus == true)
  }
  it should "open the days tally counter at start of 0" in{
    val employee = new FloorStaff("john",1,1)
    val shop = new Shop
    employee.openShop(shop,employee)
    assert(shop.todaysIncomeTally == 0)
  }


//  "As an Employee I want to sell Product/Products to customer" should "sell item(-1 from stock amount)" in{
//    val employee = new FloorStaff("john",1,1)
//    val shop = new Shop
//    val dvd = new Misc(1234, "Monsters Inc",2.50, 5)
//    shop.addItemToTheShop(dvd)
//    val stock = new Stock
//    stock.updateStockForID(1234,5)
//    val amountBeforeInStock = stock.getPreOrderAmountForThisItem(1234)
//    employee.sellItem(1234)
//    assert(stock.getAmountOfProductsForThisID(1234)==amountBeforeInStock-1)
//
//
//    //assert(employee.getItemStockQuanitity() == stock.)
//  }


}