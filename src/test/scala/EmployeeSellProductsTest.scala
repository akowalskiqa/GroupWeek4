import org.scalatest.FlatSpec

/**
  * Created by Profile on 20/06/2017.
  */

class EmployeeSellProductsTest extends FlatSpec {

  " As an Employee I" can " sell a product to a customer" in {
    val sale = new SaleRecord
    assert(sale.test == 4)
  }
}
//
//  info("As an Employee")
//  info("I want to be able to sell a product to a customer")
//
//  feature ("Sell products")
//    scenario("Employees can sell products to customers")
//    assert(true)
//
//  Given ("That the employee has permissions to sell products")
//  //val makeSale = newSale
//
//  When ("The Employee makes a sale")
//
//
//  Then ("The stock levels are updated")
//}
//
