import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen


/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateStockTest extends FeatureSpec with GivenWhenThen {

  info("As a Manager")
  info("I want to be able to update items stock")
  info("So that I know how much stock the game shop has")

  feature ("Update stock")
    scenario("Update stock figures")

  Given (" That the shop has stock")
  val viewStockAndUpdate  = newStockUpdate

  When (" The manager logs onto the system")


  Then ("The manager can update the stock quantity ")
}

