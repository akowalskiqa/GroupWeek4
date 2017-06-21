import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Shop {
  var openStatus:Boolean = false
  var listOfCustomers = ArrayBuffer[Customer]()
  var listOfFloorStaff = ArrayBuffer[FloorStaff]()
  var listOfItems = ArrayBuffer[Item]()
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
    accumulateAwardedPoints = 0
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

    def openShop(whoInvokedTheCall:Person): Unit ={
        openStatus=true
        todaysIncomeTally = 0
    }
    def closeShop(whereToKeepTheRecord:SummarySaleRecord): Unit ={
        whereToKeepTheRecord.updateDatesIncome(new java.util.Date(),todaysIncomeTally)
        openStatus = false
    }
}