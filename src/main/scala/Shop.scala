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
  var todaysIncomeTally: Int = 0

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


  def sellThis(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): Unit ={
    var totalPrice:Double = 0
    var pointPrice = 0
    var accumulateAwardedPoints = 0
    var itemsPurchased = ArrayBuffer[Item]()
    var needRandomID = true
    var randomGeneratedNumber = generateRandomNumber()

  for( i <- 0 to listOfItemsToSell.length-1){
    if(stock.getAmountOfProductsForThisID(listOfItemsToSell(i).getItemID())>0){
      totalPrice+= listOfItemsToSell(i).getItemPrice()
      pointPrice += listOfItemsToSell(i).getItemPointValue()
      stock.updateStockForID(listOfItemsToSell(i).getItemID(),-1)
      itemsPurchased+=listOfItemsToSell(i)
      accumulateAwardedPoints += listOfItemsToSell(i).getItemPointValue()
    }else{println("Product " +listOfItemsToSell(i).getItemID()+ "Is not in stock you did not buy this one")}
  }
  if(customerBuyingTheProducts.registered){
    customerBuyingTheProducts.updatePointAmount(accumulateAwardedPoints)
  }else{
    accumulateAwardedPoints =0
  }
  while(needRandomID){
    if(!listOfReceipts.contains(randomGeneratedNumber)){
      needRandomID=false
    }else{randomGeneratedNumber = generateRandomNumber()}
  }
  var saleRecord = new SaleRecord(itemsPurchased.toArray,totalPrice,new java.util.Date(),whoAmI,customerBuyingTheProducts,accumulateAwardedPoints,randomGeneratedNumber)
  customerBuyingTheProducts.allocateAReceipt(randomGeneratedNumber)
  summary.addSaleRecord(saleRecord)
  todaysIncomeTally += totalPrice
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