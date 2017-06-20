import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Shop {
  var openStatus:Boolean = false
  var ListOfCustomers = ArrayBuffer[Customer]()
  var ListOfFloorStaff = ArrayBuffer[FloorStaff]()
  var ListOfItems = ArrayBuffer[Item]()
  var ListOfSaleSummary = ArrayBuffer[SummarySaleRecord]()
  var ListOfSales = ArrayBuffer[SaleRecord]()
  var ListOfStock = ArrayBuffer[Stock]()
  var todaysIncomeTally:Int = 0
//
//
//  //Create item
//
//  def createAnItem(newItem: Item): Unit = {
//    ListOfItems += newItem
//  }
//
//  def readAnItem(ID: Int): Item = {
//    ListOfItems.foreach(item => if (item.getID() == ID) {
//      item
//    })
//}
//
//def updateAnItem(ID: Int, upItem: Item): Unit = {
//    ListOfItems.foreach(item => if (item.getID() == ID) {
//      item == upItem
//    })
//  }
//
//def deleteAnItem(ID: Int): Unit = {
//  ListOfItems.foreach(item => if (item.getID() == ID) {
//    ListOfItems -= item
//  })
//}
//
//
//
////Add FloorStaff
//
//def createAnFloorStaff(newStaff: FloorStaff): Unit = {
//  ListOfFLoorStaff += newStaff
//}
//
//  def readAnFloorStaff(ID: Int): Item = {
//        ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
//            item
//        })
//    }
//
//    def updateAnFloorStaff(ID: Int, upEmp: FloorStaff): Unit = {
//        ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
//            item == upEmp
//        })
//
//    }
//
//    def deleteAnFloorStaff(ID: Int): Unit = {
//        ListOfFLoorStaff.foreach(item => if (item.getEmpID() == ID) {
//            ListOfFLoorStaff -= item
//        })
//    }
//
//    //Stock
//
//    def updateStock(ID: Int, upStock: Stock): Unit = {
//        ListOfStock.foreach(item => if (item.getStockID() == ID) {
//            item == upStock })
//    }

    def openShop(whoInvokedTheCall:Person): Unit ={
        openStatus=true
        todaysIncomeTally = 0
    }

    def closeShop(): Unit ={
        openStatus = false
    }


}