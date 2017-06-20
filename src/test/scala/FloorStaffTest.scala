import org.scalatest.FlatSpec

/**
  * Created by Administrator on 20/06/2017.
  */
class FloorStaffTest extends FlatSpec {
  " As an Employee I wish to open the shop to tally a day's profit" should "Employee open the shop" in {
    val employee = new FloorStaff
    val shop = new Shop
    employee.openShop(shop,employee)
    assert(shop.openStatus == true)
  }
  it should "open the days tally counter at start of 0" in{
    val employee = new FloorStaff
    val shop = new Shop
    employee.openShop(shop,employee)
    assert(shop.todaysIncomeTally == 0)
  }


  "As an Employee I wish to view item's stock amount" should "return item's stock quantity" in{
    val employee = new FloorStaff
    val shop = new Shop
    val stock = new Stock


    //assert(employee.getItemStockQuanitity() == stock.)
  }


}