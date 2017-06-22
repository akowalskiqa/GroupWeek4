import org.scalatest.FlatSpec
//Working!!!!!!!!!!!!!!!!!
import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateDetailsStockTest extends FlatSpec {
  "As a Manager I" can "Update an items details " in {

    val shop = new Shop
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var item2 = shop.defineAnItem(ItemTypes.Game, "The Simpsons", 10.0, 7)

    val itemList = new ArrayBuffer[Item]()

    itemList+= item1
    itemList+= item2

    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {

      shop.listOfItems(0).setItemName("Fallout 3")

      itemList += shop.listOfItems(0)

      assert(shop.listOfItems(0).getItemName() == "Fallout 3")
      assert(itemList(2).getItemName() == "Fallout 3")
    }
  }

  it should "adjust the stock details" in {

    val shop = new Shop
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var item2 = shop.defineAnItem(ItemTypes.Game, "The Simpsons", 10.0, 7)

    val itemList = new ArrayBuffer[Item]()

    itemList+= item1
    itemList+= item2

    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {

      shop.listOfItems(1).setItemPrice(30.00)

      itemList += shop.listOfItems(1)

      assert(shop.listOfItems(1).getItemPrice() == 30.00)
      assert(itemList(2).getItemPrice() == 30.00)
    }

  }
}

