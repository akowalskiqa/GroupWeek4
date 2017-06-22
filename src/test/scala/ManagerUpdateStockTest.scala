import org.scalatest.FlatSpec
/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateStockTest extends FlatSpec {

  "As a Manager I" can "Update an items stock levels" in {
   var shop = new Shop()
    var stock = new Stock()

    var currentStock = stock.getAmountOfProductsForThisID(0)
    stock.updateStockForID(0, 5)

    assert(stock.getAmountOfProductsForThisID(0) > currentStock)
  }


  it should "adjust the stock levels" in {
    var shop = new Shop()
    var stock = new Stock()

    var currentStock = stock.getAmountOfProductsForThisID(1)
    stock.updateStockForID(1, 5)

    assert(stock.getAmountOfProductsForThisID(1) > currentStock)
  }
}

