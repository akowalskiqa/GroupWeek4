import org.scalatest.FlatSpec
/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateStockTest extends FlatSpec {

  "As a Manager I" can "Update an items stock levels" in {
    val employee = new Manager
    val shop = new Shop
    val stock = new Stock
    shop.updateStock(1, stock)
    assert(stock.updateStock ==)
  }


  it should "adjust the stock levels" in {
    val employee = new Manager
    val shop = new Shop
    val stock = new Stock
    shop.updateStock(1, stock)
    assert(stock.updateStock ==)
  }
}

