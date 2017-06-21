import java.util.Date

import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 20/06/2017.
  */

class EmployeeSellProductsTest extends FlatSpec {

  " As an Employee I" can " sell a product to a customer" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Bonestorm", 10.0, 10)
    val employee = new FloorStaff("Ryan", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Richard", 1234, true, 105)
    val itemList = new ArrayBuffer[Item]()


    assert(shop.sellThis(item1).getItemName() == "Bonestorm")

    itemList+= item1
    val array = itemList.toArray

    var sales = new SaleRecord(array, 15.75, Date, employee, customer, 10, 1234 )


  }
}
