import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

/**
  * Created by Profile on 20/06/2017.
  */
class ManagerSalesViewTest extends FeatureSpec with GivenWhenThen {

  info("As a Manager")
  info("I want to be able to view a days sales")
  info("So that I know how much money the shop has made")

  feature ("View days sales")
    scenario("Manager can view the days sales")

  Given (" That the shop has opened")
  val viewTodaysSales = newSalesRecord

  When (" The shop has made sales")


  Then ("The manager can view the days sales")
}

