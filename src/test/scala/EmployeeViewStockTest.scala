import org.scalatest.FlatSpec

class EmployeeViewStockTest extends FlatSpec {

    "As an employee I" can "view an items stock levels" in {
      val shop = new Shop
      var stock = new Stock
      var item1 = shop.defineAnItem(ItemTypes.Game, "Call of Duty",2.50, 5)
      stock.productQuantity(item1.getItemID())


      (assert(stock.getAmountOfProductsForThisID(item1)Stock.productQuantity)

    }


}
