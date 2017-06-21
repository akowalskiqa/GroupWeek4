import ItemTypes.ItemTypes

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Shop {

  //Items
  var item1 = defineAnItem(ItemTypes.Game, "Bonestorm", 10.0, 10)
  var item2 = defineAnItem(ItemTypes.Game, "Hitman", 16.0, 10)
  var item3 = defineAnItem(ItemTypes.Game, "Call of Duty", 20.0, 10)
  var item4 = defineAnItem(ItemTypes.Game, "Mariocart", 15.0, 10)
  var item5 = defineAnItem(ItemTypes.Misc, "Poster", 5.0, 10)
  var item6 = defineAnItem(ItemTypes.Misc, "T-Shirt", 15.0, 10)
  var item7 = defineAnItem(ItemTypes.Game, "Fifa", 18.0, 10)
  var item8 = defineAnItem(ItemTypes.Game, "Minecraft", 12.0, 10)
  var item9 = defineAnItem(ItemTypes.Hardware, "Headset", 30.0, 10)
  var item10 = defineAnItem(ItemTypes.Hardware, "Playstation 2", 100.0, 10)

  //Floor staff
  val staff1 = new FloorStaff("Ryan", idGenerator.uniqueEmployeeId, 1)
  val staff2 = new FloorStaff("Mike", idGenerator.uniqueEmployeeId, 1)
  val staff3 = new FloorStaff("John", idGenerator.uniqueEmployeeId, 1)
  val staff4 = new FloorStaff("Mark", idGenerator.uniqueEmployeeId, 1)
  val staff5 = new FloorStaff("Aaron", idGenerator.uniqueEmployeeId, 1)
  val staff6 = new Manager("Elliot", idGenerator.uniqueEmployeeId, 2)

  var openStatus: Boolean = false

  var ListOfCustomers: ArrayBuffer[Customer] = ArrayBuffer[Customer]()
  var ListOfFLoorStaff: ArrayBuffer[FloorStaff] = ArrayBuffer[FloorStaff]()
  var ListOfItems: ArrayBuffer[Item] = ArrayBuffer[Item]()
  var ListOfSaleSummarys: ArrayBuffer[SummarySaleRecord] = ArrayBuffer[SummarySaleRecord]()
  var ListOfSales: ArrayBuffer[SaleRecord] = ArrayBuffer[SaleRecord]()
  var ListOfStock: Stock
  var todaysIncomeTally: Int = 0

  ListOfItems += (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)
  ListOfFLoorStaff += (staff1, staff2, staff3, staff4, staff5, staff6)

  //Create item
  def defineAnItem(itemType: ItemTypes, nameOfItem: String, priceOfItem: Double, pointsOfItem: Int, preOrder: Boolean = false): Item = {

    itemType match {
      case ItemTypes.Game => {
        var newItem = new Game(idGenerator.uniqueItemId, nameOfItem, priceOfItem, pointsOfItem, preOrder)
        newItem
      }
      case ItemTypes.Hardware => {
        var newItem = new Hardware(idGenerator.uniqueItemId, nameOfItem, priceOfItem, pointsOfItem)
        newItem
      }
      case ItemTypes.Misc => {
        var newItem = new Misc(idGenerator.uniqueItemId, nameOfItem, priceOfItem, pointsOfItem)
        newItem
      }
      case _ => {
        var newItem = new Misc(idGenerator.uniqueItemId, nameOfItem, priceOfItem, pointsOfItem)
        newItem
      }
    }

  }

  def createAnItem(newItem: Item): Unit = {
    ListOfItems += newItem
  }

  def readAnItem(ID: Int): Item = {
    ListOfItems(ListOfItems.indexWhere(item => item.itemID == ID))
    //    ListOfItems.foreach(item => if (item.getItemID() == ID) return item)
  }

  def updateAnItem(ID: Int, upItem: Item): Unit = {
    ListOfItems.foreach(item => if (item.getItemID() == ID) {
      item.name=upItem.name
      item.price=upItem.price
      item.pointValue=upItem.pointValue
    })
  }

  def deleteAnItem(ID: Int): Unit = {
    ListOfItems.remove(ListOfItems.indexWhere(item => item.itemID == ID))
  }


  //Add FloorStaff
  def defineAnFloorStaff

  def createAnFloorStaff(newStaff: FloorStaff): Unit = {
    ListOfFLoorStaff += newStaff
  }

  def readAnFloorStaff(ID: Int): FloorStaff = {
    ListOfFLoorStaff(ListOfFLoorStaff.indexWhere(floorStaff => floorStaff.employeeID == ID))
    //   ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {item})
  }

  def updateAnFloorStaff(ID: Int, upEmp: FloorStaff): Unit = {
    ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {
      item.name = upEmp.name
      item.authorityLevel = upEmp.authorityLevel
    })
  }

  def deleteAnFloorStaff(ID: Int): Unit = {
    ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {
      ListOfFLoorStaff -= item
    })
  }

  //Stock

  def getAmountForThisID(chcekAmountForThisID: Int): Int = {
    ListOfStock.productQuantity(checkAmountForThisID)
  }

  def updateStockForID(iDToUpdate: Int, newQuantityToUpdateTo: Int): Unit = {
    ListOfStock.updateStockForID(iDToUpdate, newQuantityToUpdateTo)
  }

  def updatePreOrderForID(preOrderID: Int): Unit = {
    ListOfStock.updatePreOrderForID(preOrderID)
  }

  def openShop(whoInvokedTheCall: Person): Unit = {
    openStatus = true
    todaysIncomeTally = 0
  }

  def closeShop(): Unit = {
    openStatus = false
  }

  //Receipt



  object idGenerator {
    private val clockticker = new java.util.concurrent.atomic.AtomicInteger
    private val clockticker2 = new java.util.concurrent.atomic.AtomicInteger
    private val clockticker3 = new java.util.concurrent.atomic.AtomicInteger

    def uniqueCustomerId: Int = clockticker.getAndIncrement + 1

    def uniqueEmployeeId: Int = clockticker2.getAndIncrement + 1

    def uniqueItemId: Int = clockticker3.getAndIncrement + 1
  }

}