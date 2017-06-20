import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeSellProductsTest extends FeatureSpec with GivenWhenThen {

  info("As an Employee")
  info("I want to be able to sell a product to a customer")

  feature ("Sell products")
    scenario("Employees can sell products to customers")

  Given ("That the employee has permissions to sell products")
  val makeSale = newSale

  When ("The Employee makes a sale")


  Then ("The stock levels are updated")
}

