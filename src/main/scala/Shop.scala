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


def sellThis(listOfItemsToSell:Array[Item],stock:Stock): (Array[Item],Double, Int) ={
  if(openStatus) {
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
    (itemsToBePurchased.toArray,totalPrice,pointPrice)

  }else{println("Show needs to be open before anything can be sold!")}
  (Array[Item](),1.02,0)
}

  def acceptPayment(listForPurchaseFinalisation:Array[Item],cost:Double,paymentWithPoints:Option[Int]= None,customerBuyingTheProducts:Customer,whoAmI:FloorStaff,stock:Stock,summary:SummarySaleRecord): Unit ={
    val points = paymentWithPoints getOrElse 0
    var needRandomID = true
    var randomGeneratedNumber = generateRandomNumber()
    var pointsToBeAwardedForPurchase = (cost/10).toInt
    if(points >0){
      listOfCustomers(listOfCustomers.indexOf(customerBuyingTheProducts)).updatePointAmount(-points)
      pointsToBeAwardedForPurchase = 0
    }else{
      todaysIncomeTally +=cost
      if(customerBuyingTheProducts.registered){

      if(listOfCustomers.contains(customerBuyingTheProducts)) {
        listOfCustomers(listOfCustomers.indexOf(customerBuyingTheProducts)).updatePointAmount(pointsToBeAwardedForPurchase)
      }}
    }
    listForPurchaseFinalisation.foreach(item=> stock.updateStockForID(item.getItemID(),-1))

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

    def openShop(): Unit ={
        openStatus=true
        todaysIncomeTally = 0
    }
    def closeShop(whereToKeepTheRecord:SummarySaleRecord): Unit ={
        whereToKeepTheRecord.updateDatesIncome(new java.util.Date(),todaysIncomeTally)
        openStatus = false
    }
}