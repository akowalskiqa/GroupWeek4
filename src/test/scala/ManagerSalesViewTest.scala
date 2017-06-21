import org.scalatest.FlatSpec
import java.util.Date

import scala.collection.mutable.ArrayBuffer
/**
  * Created by Profile on 20/06/2017.
  */
class ManagerSalesViewTest extends FlatSpec {

  "As a Manager I" can "view sales on a daily basis" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Misc, "Monsters Inc",2.50, 5)
    var item2 = shop.defineAnItem(ItemTypes.Misc, "Terminator",2.50, 5)
    var item3 = shop.defineAnItem(ItemTypes.Game, "Halo",2.50, 5)
    var employee = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)
    val employee1 = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Jack", 1234, true, 105)
    val itemList = new ArrayBuffer[Item]()

    itemList+= item1
    itemList+= item2
    itemList+= item3
    val array = itemList.toArray


    var sales = new SaleRecord(array, 15.75, Date, employee1, customer, 10, 1234 )

    shop.listOfSales += sales
    //val employee = new Manager
    //val sales = new SaleRecord
    //val shop = new Shop
    //var amountOfDailySales = employee.getDailySales(19.06.2017)
    assert(shop.listOfSales.nonEmpty)
    assert(shop.listOfSales.head.totalCost == 15.75)

  }

  it should "Allow the manager to view sales from other days" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Misc, "Monsters Inc",2.50, 5)
    var item2 = shop.defineAnItem(ItemTypes.Misc, "Terminator",2.50, 5)
    var item3 = shop.defineAnItem(ItemTypes.Game, "Halo",2.50, 5)
    val employee1 = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)
    val customer = new Customer("Jack", 1234, true, 105)
    val itemList = new ArrayBuffer[Item]()

    itemList+= item1
    itemList+= item2
    itemList+= item3
    val array = itemList.toArray

    var sales = new SaleRecord(array, 15.75, Date , employee1, customer, 10, 1234 )
    var sales2 = new SaleRecord(array, 12.25, Date , employee1, customer, 15, 1330 )
    shop.listOfSales += (sales, sales2)

    assert(shop.listOfSales.nonEmpty)
    //assert(shop.listOfItems.indexWhere(item => item.getItemPrice() == 12.25))

  }

}

