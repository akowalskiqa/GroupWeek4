import org.scalatest.FlatSpec

/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateDetailsStock extends FlatSpec {
  "As a Manager I" can "Update an items details " in {
    val shop = new Shop
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    val employee = new Manager("Mike", shop.idGenerator.uniqueEmployeeId)
    if (employee.isInstanceOf[Manager]){

      shop.updateAnItem(1, item1)
      assert(shop.listOfItems(1).getItemName() == "Mass Effect")
    }

  }

}
//  it should "adjust the stock details" in {
//    val employee = new Manager
//    val shop = new Shop
//    val stock = new Stock
//    shop.updateStockDetails(1, stock)
//    assert(stock. == )
//  }
//}
//
//
//val stock = new Stock
//shop.updateStockDetails(1, stock)
//assert(stock.Stock ==)