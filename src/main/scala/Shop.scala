import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Shop {

  //Items
  val item1 = new Game(1, "Bonestorm")
  val item2 = new Game(2, "Hitman")
  val item3 = new Game(3, "Call of Duty")
  val item4 = new Game(4, "Mariocart")
  val item5 = new Misc(5, "Poster")
  val item6 = new Misc(6, "T-Shirt")
  val item7 = new Game(7, "Fifa")
  val item8 = new Game(8, "Minecraft")
  val item9 = new Hardware(9, "Headset")
  val item10 = new Hardware(10, "Playstation 2")

  //Floor staff
  val staff1 = new FloorStaff(1, "Ryan")
  val staff2 = new FloorStaff(2, "Mike")
  val staff3 = new FloorStaff(3, "John")
  val staff4 = new FloorStaff(4, "Mark")
  val staff5 = new FloorStaff(5, "Aaron")

  var ListOfCustomers = ArrayBuffer[Customer]()
  var ListOfFLoorStaff = ArrayBuffer[FloorStaff]()
  var ListOfItems = ArrayBuffer[Item]()
  var ListOfSaleSummarys = ArrayBuffer[SummarySaleRecord]()
  var ListOfSales = ArrayBuffer[SaleRecord]()
  var ListOfStock = ArrayBuffer[Stock]()

  ListOfItems += (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10)
  ListOfFLoorStaff += (staff1, staff2, staff3, staff4, staff5)

  //Create item

  def createAnItem(newItem: Item): Unit = {
    ListOfItems += newItem
  }

  def readAnItem(ID: Int): Item = {
    ListOfItems.foreach(item => if (item.getID() == ID) {
      item
    })
}

def updateAnItem(ID: Int, upItem: Item): Unit = {
    ListOfItems.foreach(item => if (item.getID() == ID) {
      item == upItem
    })
  }

def deleteAnItem(ID: Int): Unit = {
  ListOfItems.foreach(item => if (item.getID() == ID) {
    ListOfItems -= item
  })
}



//Add FloorStaff

def createAnFloorStaff(newStaff: FloorStaff): Unit = {
  ListOfFLoorStaff += newStaff
}

  def readAnFloorStaff(ID: Int): Item = {
    ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
      item
    })
  }

def updateAnFloorStaff(ID: Int, upEmp: FloorStaff): Unit = {
    ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
      item == upEmp
    })

}

def deleteAnFloorStaff(ID: Int): Unit = {
  ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
    ListOfFLoorStaff -= item
  })
}

  //Stock

  def updateStock(ID: Int, upStock: Stock): Unit = {
    ListOfStock.foreach(item => if (item.getStockID() == ID) {
      item == upStock })
  }
}