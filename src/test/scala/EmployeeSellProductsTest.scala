import java.util.Date

import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 20/06/2017.
  */

class EmployeeSellProductsTest extends FlatSpec {

  " As an Employee I" can " sell a product to a customer" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Bonestorm", 10.0, 10)
    var shoppingList = Array(item1)
    var stockList = new Stock()
    stockList.productQuantity +=(11-> 100)
    val whoInvokedThisCall = new FloorStaff("Ryan", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Richard", 1234, true, 105)
    if (whoInvokedThisCall.isInstanceOf[FloorStaff]) {

      shop.sellThis  (shoppingList, stockList)
      //  assert(shoppingList.exists(item => item.getItemName()=="Bonestorm"))
      assert(shoppingList.contains(("Bonestorm")))
    }

  }
}