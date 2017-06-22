import java.util.Date

import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

class ManagerTests extends FlatSpec{

  //ManagerAddEmployee
  "As a Manager I want to be able to add an employee to the system" should "Add an employee" in {
    var shop = new Shop()
    var employee1 = new FloorStaff("Fred", shop.idGenerator.uniqueEmployeeId)
    shop.createAnFloorStaff(employee1)
    assert(shop.listOfFLoorStaff.last == employee1)
  }
  //ManagerRemoveEmployee
  "As a Manager I want to be able to Delete employee to the system" should "Delete an employee from the system" in {
    var shop = new Shop()
    var employee1 = new FloorStaff("Fred", shop.idGenerator.uniqueEmployeeId)
    shop.createAnFloorStaff(employee1)
    shop.deleteAnFloorStaff(employee1.employeeID)
    assert(shop.listOfFLoorStaff.last !== employee1)
  }
  //ManagerAddNewItemToList
  "As a Manager I want to be able to add a new item to the list" should "Add a new item to the list" in {
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var itemlist: ArrayBuffer[Item] = ArrayBuffer()

    itemlist += item1 // Item is added into the list
    assert(itemlist.last == item1) //Item is generated
  }
  //ManagerAddItemStockToList
  "As a Manager I want to be able to add that new item to the stock I " should "Add a new item to stock" in {
    //
    var shop = new Shop()
    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)
    var stock = new Stock()

    stock.updateStockForID(0, 5)
    stock.updateStockForID(1, 7)
    stock.updateStockForID(item1.getItemID(), 16)

    assert(stock.getAmountOfProductsForThisID(item1.getItemID()) === 16) //ItemList contains something
  }
  //ManagerDeleteItemInList
  "As a Manager I" should "be able to delete items from the items list" in {
    val shop = new Shop()
    val whoInvokedThisCall = new Manager("Elliot", shop.idGenerator.uniqueEmployeeId)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.listOfItems(3).getItemName() != "Mariocart")
      assert(shop.listOfItems.length < 9)
    }
  }
  it should "not delete if user is not a Manager" in {

    val shop = new Shop()
    val whoInvokedThisCall = new FloorStaff("John", shop.idGenerator.uniqueEmployeeId)

    if (whoInvokedThisCall.isInstanceOf[Manager]) {
      shop.deleteAnItem(4)
      shop.deleteAnItem(8)
      assert(shop.listOfItems(3).getItemName() == "Mariocart")
      assert(shop.listOfItems.length == 10)
    }
  }

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
    val today:Date = new java.util.Date


    var sales = new SaleRecord(array, 15.75, today, employee1, customer, 10, 1234 )

    shop.listOfSales += sales
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
    val today:Date = new java.util.Date

    itemList+= item1
    itemList+= item2
    itemList+= item3
    val array = itemList.toArray

    var sales = new SaleRecord(array, 15.75, today , employee1, customer, 10, 1234 )
    var sales2 = new SaleRecord(array, 12.25, today , employee1, customer, 15, 1330 )
    shop.listOfSales += (sales, sales2)

    assert(shop.listOfSales.length == 2)
    assert(shop.listOfSales(1).totalCost == 12.25)
  }
}
