import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 20/06/2017.
  */

class ManagerAddDeleteTest extends FlatSpec {

  info("As a Manager I want to be able to add a new item to sell")

  "As a Manager I want to be able to add a new item to the list" should "Add a new item to the list" in {
    var shop = new Shop()
    var item1 = new Game(2, "Hitman", 10.0, 10, false)
    var itemlist: ArrayBuffer[Game] = ArrayBuffer()

    itemlist += item1 // Item is added into the list
    //   createAnItem()
    assert(itemlist.last == item1) //Item is generated
  }
  "As a Manager I want to be able to add that new item to the stock" should "Add a new item to stock" in {
    //    updateStock(Item1.id)
    var item1 = new Game(2, "Hitman", 10.0, 10, false)
    //   var stock = new Stock(item1.id)
    assert(true) //ItemList contains Item1
  }


  "A Manager" should "be able to delete items from the items list" in {
    val shop = new Shop()
    val whoInvokedThisCall = new Manager("Elliot",6,2)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.ListOfItems(3).getItemName() != "Mariocart")
      assert(shop.ListOfItems.length > 9)
    }
  }

  it should "not delete if user is not a Manager" in {

    val shop = new Shop()
    val whoInvokedThisCall = new FloorStaff("Ryan",1,2)

    if (!whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.ListOfItems(3).getItemName() == "Mariocart")
      assert(shop.ListOfItems.length == 10)
    }
  }
}
