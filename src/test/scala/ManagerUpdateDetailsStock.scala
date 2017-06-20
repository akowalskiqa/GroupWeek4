import org.scalatest.FlatSpec

/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateDetailsStock extends FlatSpec  {
  "As a Manager I" can "Update an items details " in {
    val employee = new Manager
    val shop = new Shop
    val stock = new Stock
    shop.updateStockDetails(1, stock)
    assert(stock.Stock == )

  }
  it should "adjust the stock details" in {
    val employee = new Manager
    val shop = new Shop
    val stock = new Stock
    shop.updateStockDetails(1, stock)
    assert(stock. == )
  }
}

