import org.scalatest.FlatSpec
/**
  * Created by Profile on 20/06/2017.
  */
class ManagerSalesViewTest extends FlatSpec {

  "As a Manager I" can "view sales on a daily basis" in {
    val employee = new Manager
    val sales = new SaleRecord
    val shop = new Shop
    var amountOfDailySales = employee.getDailySales(19.06.2017)
    assert()

  }

  it should "Allow the manager to view sales from other days" in {
    val employee = new Manager
    val sales = new SaleRecord
    val shop = new Shop
    var selectedDateSales = employee.selectedDateSales(15.04.2017)
    assert()
  }

}

//
//
//  info("I want to be able to view a days sales")
//  info("So that I know how much money the shop has made")
//
//  feature ("View days sales")
//    scenario("Manager can view the days sales")
//
//  Given (" That the shop has opened")
//  val viewTodaysSales = newSalesRecord
//
//  When (" The shop has made sales")
//
//
//  Then ("The manager can view the days sales")
//}
//
