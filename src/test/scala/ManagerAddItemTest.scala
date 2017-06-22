import org.scalatest._

import scala.collection.mutable.ArrayBuffer
/**
  * Created by Profile on 20/06/2017.
  */
//Working
class ManagerAddItemTest extends FlatSpec {

  info("As a Manager I want to be able to add a new item to sell")

  "As a Manager I want to be able to add a new item to the list" should "Add a new item to the list" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var itemlist: ArrayBuffer[Item] = ArrayBuffer()

    itemlist += item1 // Item is added into the list
    assert(itemlist.last == item1) //Item is generated
  }

  "As a Manager I want to be able to add that new item to the stock" should "Add a new item to stock" in {
    //
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var stock = new Stock()

    stock.updateStockForID(0, 5)
    stock.updateStockForID(1, 7)
    stock.updateStockForID(item1.getItemID(), 16)

    assert(stock.getAmountOfProductsForThisID(item1.getItemID()) == 16) //ItemList contains something
  }
}
