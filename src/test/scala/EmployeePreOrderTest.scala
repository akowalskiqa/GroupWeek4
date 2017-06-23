import org.scalatest.FlatSpec

//completed
class EmployeePreOrderTest extends FlatSpec{

  "As an employee I" should " be able to pre order an item for a customer"
  var shop = new Shop
  shop.openShop()
  var stock = new Stock
  stock.addPreOrderToThisItem(1)
  stock.addPreOrderToThisItem(1)

  (assert(stock.productPreOrderRequestAmount(1) === 2))
}
