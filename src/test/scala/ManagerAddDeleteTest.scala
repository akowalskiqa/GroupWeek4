import org.scalatest.{FeatureSpec, FunSuite, GivenWhenThen}

/**
  * Created by Administrator on 20/06/2017.
  */
class ManagerAddDeleteTest extends FeatureSpec with GivenWhenThen {

  info("As a Manager")
  info("I want to be able to add or delete a Items to the system")
  info("So I can keep selling the latest products")
  info("And ahead of my competitors")

  feature("Adding a Item to the list"){
    scenario("Manager adds a new Item to the list of items"){
      Given("The Item to be added is not in the list already")
    //  val Item1 = new Item(id:Int,name:String, price: Double, pointValue:Int)
      val shop = new Shop()

      assert(shop.test == 4)//ItemList doesn't Contains Item1

      When("Item is added")
      //addItemToList(Item1)

      Then("The new item is added onto the list")
     // assert(true)//ItemList contains Item1
    }
  }
}
