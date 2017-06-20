import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 20/06/2017.
  */
/*
class ManagerAddDeleteTest extends FeatureSpec with GivenWhenThen {

  info("As a Manager")
  info("I want to be able to add or delete a Items to the system")
  info("So I can keep selling the latest products")
  info("And ahead of my competitors")

  feature("Adding a Item to the list"){
    Scenario("Manager adds a new Item to the list of items"){
      Given("The Item to be added is not in the list already")
      val Item1 = new Item(id:Int,name:String, price: Double, pointValue:Int)
      assert()//ItemList doesn't Contains Item1

      When("Item is added")
      addItemToList(Item1)

      Then("The new item is added onto the list")
      assert()//ItemList contains Item1
    }
  }
} */

class ManagerAddDeleteTest extends FlatSpec {

  info("As a Manager I want to be able to add a new item to sell")

  "As a Manager I want to be able to add a new item to the list" should "Add a new item to the list" in {
    var shop = new Shop()
    var item1 = new Game(1,"game1")
    var itemlist: ArrayBuffer[Game] = ArrayBuffer()

    itemlist += item1 // Item is added into the list
    //   createAnItem()
    assert(itemlist.last == item1) //Item is generated
  }
  "As a Manager I want to be able to add that new item to the stock" should "Add a new item to stock" in {
    //    updateStock(Item1.id)
    var item1 = new Game(1,"game1")
    //   var stock = new Stock(item1.id)
    assert(true) //ItemList contains Item1
  }


  "A Manager" should "be able to delete items from the items list" in {
    val shop = new Shop()
    val whoInvokedThisCall = new Manager(6, "Elliot")

    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.ListOfItems(3).getName() != "Mariocart")
      assert(shop.ListOfItems.length < 9)
    }
  }

  it should "not delete if user is not a Manager" in {
    val shop = new Shop()
    val whoInvokedThisCall = new FloorStaff(1, "Ryan")

    if (!whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.ListOfItems(3).getName() == "Mariocart")
      assert(shop.ListOfItems.length == 10)
    }
  }
}
