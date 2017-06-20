import org.scalatest.FlatSpec

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

class ManagerDeleteTest extends FlatSpec {

  "A Manager" should "be able to delete items from the items list" in {
    val shop = new Shop()
    val whoInvokedThisCall = new Manager(6, "Elliot")

    if(whoInvokedThisCall.isInstanceOf[Manager]) {
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
