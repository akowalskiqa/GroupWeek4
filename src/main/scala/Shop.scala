import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Shop {

  //Items
  val item1 = new Game(idGenerator.uniqueItemId, "Bonestorm", 10.0, 10, false)
  val item2 = new Game(idGenerator.uniqueItemId, "Hitman", 16.0, 10, false)
  val item3 = new Game(idGenerator.uniqueItemId, "Call of Duty", 20.0, 10, false)
  val item4 = new Game(idGenerator.uniqueItemId, "Mariocart", 15.0, 10, false)
  val item5 = new Misc(idGenerator.uniqueItemId, "Poster", 5.0, 10)
  val item6 = new Misc(idGenerator.uniqueItemId, "T-Shirt", 15.0, 10)
  val item7 = new Game(idGenerator.uniqueItemId, "Fifa", 18.0, 10, false)
  val item8 = new Game(idGenerator.uniqueItemId, "Minecraft", 12.0, 10, false)
  val item9 = new Hardware(idGenerator.uniqueItemId, "Headset", 30.0, 10)
  val item10 = new Hardware(idGenerator.uniqueItemId, "Playstation 2", 100.0, 10)

  //Floor staff
  val staff1 = new FloorStaff("Ryan", idGenerator.uniqueCustomerId, 1)
  val staff2 = new FloorStaff("Mike", idGenerator.uniqueCustomerId, 1)
  val staff3 = new FloorStaff("John", idGenerator.uniqueCustomerId, 1)
  val staff4 = new FloorStaff("Mark", idGenerator.uniqueCustomerId, 1)
  val staff5 = new FloorStaff("Aaron", idGenerator.uniqueCustomerId, 1)
  val staff6 = new Manager("Elliot", idGenerator.uniqueCustomerId, 2)

  var openStatus:Boolean = false

  var ListOfCustomers = ArrayBuffer[Customer]()
  var ListOfFLoorStaff = ArrayBuffer[FloorStaff]()
  var ListOfItems = ArrayBuffer[Item]()
  var ListOfSaleSummarys = ArrayBuffer[SummarySaleRecord]()
  var ListOfSales = ArrayBuffer[SaleRecord]()
  var ListOfStock = ArrayBuffer[Stock]()
  var todaysIncomeTally:Int = 0

  ListOfItems += (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)
  ListOfFLoorStaff += (staff1, staff2, staff3, staff4, staff5, staff6)

  //Create item

  def createAnItem(newItem: Item): Unit = {
    ListOfItems += newItem
  }
/*
  def readAnItem(ID: Int): Item = {
    ListOfItems.foreach(item => if (item.getItemID() == ID) {
      item
    })
} */

def updateAnItem(ID: Int, upItem: Item): Unit = {
    ListOfItems.foreach(item => if (item.getItemID() == ID) {
      item == upItem
    })
  }

def deleteAnItem(ID: Int): Unit = {
  ListOfItems.foreach(item => if(item.getItemID() == ID) {
    ListOfItems -= item
  })
}



//Add FloorStaff

def createAnFloorStaff(newStaff: FloorStaff): Unit = {
  ListOfFLoorStaff += newStaff
}

  def readAnFloorStaff(ID: Int): Item = {
    ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {
      item
    })
  }

def updateAnFloorStaff(ID: Int, upEmp: FloorStaff): Unit = {
    ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {
      item == upEmp
    })

}

def deleteAnFloorStaff(ID: Int): Unit = {
  ListOfFLoorStaff.foreach(item => if (item.getEmployeeID() == ID) {
    ListOfFLoorStaff -= item
  })
}

  //Stock

  def updateStock(ID: Int, upStock: Stock): Unit = {
    ListOfStock.foreach(item => if (item.getStockID() == ID) {
      item == upStock })
  }

  def openShop(whoInvokedTheCall:Person): Unit ={
    if(whoInvokedTheCall.isInstanceOf[FloorStaff]){
      openStatus=true
      todaysIncomeTally = 0}
    else{}
  }

  def closeShop(): Unit ={

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