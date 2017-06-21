import ItemTypes.ItemTypes
import PersonType.PersonType

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
  val staff1 = new FloorStaff("Ryan", idGenerator.uniqueEmployeeId)
  val staff2 = new FloorStaff("Mike", idGenerator.uniqueEmployeeId)
  val staff3 = new FloorStaff("John", idGenerator.uniqueEmployeeId)
  val staff4 = new FloorStaff("Mark", idGenerator.uniqueEmployeeId)
  val staff5 = new FloorStaff("Aaron", idGenerator.uniqueEmployeeId)
  val staff6 = new Manager("Elliot", idGenerator.uniqueEmployeeId)

  var openStatus: Boolean = false

  var listOfCustomers: ArrayBuffer[Customer] = ArrayBuffer[Customer]()
  var listOfFLoorStaff: ArrayBuffer[FloorStaff] = ArrayBuffer[FloorStaff]()
  var listOfItems: ArrayBuffer[Item] = ArrayBuffer[Item]()
  var listOfSaleSummarys: ArrayBuffer[SummarySaleRecord] = ArrayBuffer[SummarySaleRecord]()
  var listOfSales: ArrayBuffer[SaleRecord] = ArrayBuffer[SaleRecord]()
  var listOfStock: Stock = null
  var listOfReceipts = new ArrayBuffer[Int]()
  var listOfItemsToSell: ArrayBuffer[Item] = ArrayBuffer[Item]()
  var todaysIncomeTally: Double = 0

  listOfItems += (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)
  listOfFLoorStaff += (staff1, staff2, staff3, staff4, staff5, staff6)

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

  def addItemToShoppingBasket(itemId: Int):ArrayBuffer[Item]={
    listOfItemsToSell += listOfItems(listOfItems.indexWhere(item => item.getItemID() == itemId))
  }

  def clearShoppingBasket():Unit= {
      listOfItemsToSell.clear
  }

  def removeItemById(itemId: Int): Unit = {
    listOfItemsToSell.remove(listOfItemsToSell.indexWhere(item => item.getItemID()== itemId))
  }

  def sellThis(listOfItemsToSell: Array[Item], stock: Stock): Some[(Array[Item], Double, Int)] = {
    if (openStatus) {
      var totalPrice: Double = 0
      var pointPrice = 0
      var itemsToBePurchased = ArrayBuffer[Item]()

      for (i <- 0 to listOfItemsToSell.length - 1) {
        if (stock.getAmountOfProductsForThisID(listOfItemsToSell(i).getItemID()) > 0) {
          totalPrice += listOfItemsToSell(i).getItemPrice()
          pointPrice += listOfItemsToSell(i).getItemPointValue()
          itemsToBePurchased += listOfItemsToSell(i)
        } else {
          println("Product " + listOfItemsToSell(i).getItemID() + "Is not in stock you did not buy this one")
        }
      }
      Some(itemsToBePurchased.toArray, totalPrice, pointPrice) //

    } else {
      println("Show needs to be open before anything can be sold!")
    }
    null
  }

  def acceptPayment(listForPurchaseFinalisation: Array[Item], cost: Double,customerBuyingTheProducts: Customer, whoAmI: FloorStaff, stock: Stock, summary: SummarySaleRecord, paymentWithPoints: Option[Int] = None): Unit = {
    val points = paymentWithPoints getOrElse 0
    var needRandomID = true
    var randomGeneratedNumber = generateRandomNumber()
    var pointsToBeAwardedForPurchase = (cost / 10).toInt
    if (points > 0) {
      listOfCustomers(listOfCustomers.indexOf(customerBuyingTheProducts)).updatePointAmount(-points)
      pointsToBeAwardedForPurchase = 0
    } else {
      todaysIncomeTally += cost
      if (customerBuyingTheProducts.registered) {

        if (listOfCustomers.contains(customerBuyingTheProducts)) {
          listOfCustomers(listOfCustomers.indexOf(customerBuyingTheProducts)).updatePointAmount(pointsToBeAwardedForPurchase)
        }
      }
    }
    listForPurchaseFinalisation.foreach(item => stock.updateStockForID(item.getItemID(), -1))

    while (needRandomID) {
      if (!listOfReceipts.contains(randomGeneratedNumber)) {
        needRandomID = false
      } else {
        randomGeneratedNumber = generateRandomNumber()
      }
    }
    var saleRecord = new SaleRecord(listForPurchaseFinalisation, cost, new java.util.Date(), whoAmI, customerBuyingTheProducts, pointsToBeAwardedForPurchase, randomGeneratedNumber)
    customerBuyingTheProducts.allocateAReceipt(randomGeneratedNumber)
    summary.addSaleRecord(saleRecord)
    todaysIncomeTally += cost
  }

  def generateRandomNumber(): Int ={
    val r = scala.util.Random
    r.nextInt(99999999).abs

  }

  def createAnItem(newItem: Item): Unit = {
    listOfItems += newItem
  }

  def readAnItem(ID: Int): Item = {
    listOfItems(listOfItems.indexWhere(item => item.getItemID() == ID))
    //    ListOfItems.foreach(item => if (item.getItemID() == ID) return item)
  }

  def updateAnItem(ID: Int, upItem: Item): Unit = {
    listOfItems.foreach(item => if (item.getItemID() == ID) {
      item.setItemName(upItem.getItemName()) //item.name=upItem.name
      item.setItemPrice(upItem.getItemPrice()) //item.price=upItem.price
      item.setItemPointValue(upItem.getItemPointValue()) //item.pointValue=upItem.pointValue
    })
  }

  def deleteAnItem(ID: Int): Unit = {
    listOfItems.remove(listOfItems.indexWhere(item => item.getItemID() == ID))
  }


  //Add FloorStaff
  def defineAnPersonType(personType: PersonType, name: String, employeeID: Int): Person = {

    personType match {
      case PersonType.Manager => {
        var newPerson = new Manager(name, idGenerator.uniqueEmployeeId)
        newPerson
      }
      case PersonType.FloorStaff => {
        var newPerson = new FloorStaff(name, idGenerator.uniqueEmployeeId)
        newPerson
      }
      case _ => {
        var newPerson = new Customer(name, idGenerator.uniqueCustomerId, false, 0)
        newPerson
      }
    }

  }

  def createAnFloorStaff(newStaff: FloorStaff): Unit = {
    listOfFLoorStaff += newStaff
  }

  def readAnFloorStaff(ID: Int): FloorStaff = {
    listOfFLoorStaff(listOfFLoorStaff.indexWhere(floorStaff => floorStaff.employeeID == ID))
    //   ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {item})
  }

  def updateAnFloorStaff(ID: Int, personType:PersonType , newName:String): Unit = {
    personType match {
      case PersonType.Manager => {
        var newPerson = new Manager(newName,ID)
        listOfFLoorStaff.insert(listOfFLoorStaff.indexWhere(floorStaff => floorStaff.employeeID == ID),newPerson)
      }
      case _ => {
        var newPerson = new FloorStaff(newName, ID)
        listOfFLoorStaff.insert(listOfFLoorStaff.indexWhere(floorStaff => floorStaff.employeeID == ID),newPerson)
      }
    }
  }

  def deleteAnFloorStaff(ID: Int): Unit = {
    listOfFLoorStaff.foreach(item => if (item.employeeID == ID) {
      listOfFLoorStaff -= item
    })
  }

  //Stock

  def getAmountForThisID(checkAmountForThisID: Int): Int = {
    listOfStock.productQuantity(checkAmountForThisID)
  }

  def updateStockForID(iDToUpdate: Int, newQuantityToUpdateTo: Int): Unit = {
    listOfStock.updateStockForID(iDToUpdate, newQuantityToUpdateTo)
  }

  def addPreOrderToThisItem(preOrderID: Int): Unit = {
    listOfStock.addPreOrderToThisItem(preOrderID)
  }

  def openShop(): Unit = {
    openStatus = true
    todaysIncomeTally = 0
  }

  def closeShop(whereToKeepTheRecord: SummarySaleRecord): Unit = {
    whereToKeepTheRecord.updateDatesIncome(new java.util.Date(), todaysIncomeTally)
    openStatus = false
  }



  object idGenerator {
    private val clockticker = new java.util.concurrent.atomic.AtomicInteger
    private val clockticker2 = new java.util.concurrent.atomic.AtomicInteger
    private val clockticker3 = new java.util.concurrent.atomic.AtomicInteger

    def uniqueCustomerId: Int = clockticker.getAndIncrement + 1

    def uniqueEmployeeId: Int = clockticker2.getAndIncrement + 1

    def uniqueItemId: Int = clockticker3.getAndIncrement + 1
  }

}