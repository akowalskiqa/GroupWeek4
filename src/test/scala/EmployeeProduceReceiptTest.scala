import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeProduceReceiptTest extends FeatureSpec with GivenWhenThen {

  info("As an Employee")
  info("I want to be able to produce a receipt for a customer ")
  info("So that they have a record of their purchase ")

  feature ("Produce receipt")
    scenario("Employees can produce a receipt for customers")

  Given ("That the employee has sold a product")
  val makeSale = newSale

  When ("The Employee makes a sale")


  Then ("The system prints a receipt")
}

