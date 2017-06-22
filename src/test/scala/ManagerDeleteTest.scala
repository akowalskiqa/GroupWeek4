import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 20/06/2017.
  */

class ManagerDeleteTest extends FlatSpec {


  "A Manager" should "be able to delete items from the items list" in {
    val shop = new Shop()
    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.listOfItems(3).getItemName() != "Mariocart")
      assert(shop.listOfItems.length > 9)
    }
  }

  it should "not delete if user is not a Manager" in {

    val shop = new Shop()
    val whoInvokedThisCall = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)

    if (!whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.listOfItems(3).getItemName() == "Mariocart")
      assert(shop.listOfItems.length == 10)
    }
  }
}
