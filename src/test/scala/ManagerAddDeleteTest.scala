import org.scalatest.FunSuite

/**
  * Created by Administrator on 20/06/2017.
  */
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
}
