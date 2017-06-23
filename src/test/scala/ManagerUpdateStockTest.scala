import org.scalatest.FlatSpec
/**
  * Created by Profile on 20/06/2017.
  */
//Working
class ManagerUpdateStockTest extends FlatSpec {

  "As a Manager I" can "add new items to stock" in {
   var shop = new Shop()
    var stock = new Stock()

    stock.updateStockForID(0, 5)
    stock.updateStockForID(2, 7)
    stock.updateStockForID(3, 3)
    stock.updateStockForID(4, 4)
    stock.updateStockForID(123,11)

    assert((stock.getAmountOfProductsForThisID(123) == 11) && stock.getAmountOfProductsForThisID(4) == 4)
  }


  it should "allow adjustment of the stock levels" in {
    var shop = new Shop()
    var stock = new Stock()

    stock.updateStockForID(0, 5)
    stock.updateStockForID(2, 7)
    stock.updateStockForID(3, 3)
    stock.updateStockForID(4, 4)

    var currentStock = stock.getAmountOfProductsForThisID(2)

    stock.updateStockForID(2, 9)

    assert(stock.getAmountOfProductsForThisID(2) > currentStock)
  }
}

