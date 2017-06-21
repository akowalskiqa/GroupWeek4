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
  var todaysIncomeTally:Double = 0
  var listOfReceipts = new ArrayBuffer[Int]()


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