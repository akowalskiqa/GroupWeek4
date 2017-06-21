import org.scalatest.FlatSpec

/**
  * Created by Profile on 20/06/2017.
  */
class ManagerUpdateDetailsStock extends FlatSpec {
  "As a Manager I" can "Update an items details " in {
    val shop = new Shop
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)
    if (whoInvokedThisCall.isInstanceOf[Manager]) {

      shop.updateAnItem(1, item1)
      assert(shop.listOfItems(1).getItemName() == "Mass Effect")
    }


    //
    //
    //
    //      shop.deleteAnItem(4)
    //      shop.deleteAnItem(8)
    //      assert(shop.listOfItems(3).getItemName() != "Mariocart")
    //      assert(shop.listOfItems.length > 9)
    //    }
    //  }
  }
  it should "adjust the stock details" in {

    val shop = new Shop
    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)
    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.updateStockForID(1, 55)
      assert(shop.listOfItems(55).getItemName() == "Mass Effect")

    }

  }
}

