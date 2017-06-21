/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(name:String,val employeeID: Int,var authorityLevel:Int) extends Person(name) {
  require(0<=authorityLevel&&authorityLevel<=2)
  def getEmployeeID():Int={employeeID}
  def getAuthorityLevel():Int={authorityLevel}
  def setAuthoityLevel(newAuthlevel:Int):Unit={authorityLevel=newAuthlevel}



  def openShop(shopToOpen: Shop): Unit ={
    shopToOpen.openShop()
  }
  def closeShop(shopToClose : Shop,whereToUpdateTheTally:SummarySaleRecord):Unit ={
  shopToClose.closeShop(whereToUpdateTheTally)
  }
  def sellItem(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): (Array[Item], Double, Int) ={
    shop.sellThis(listOfItemsToSell,stock) getOrElse  (Array[Item](), 0, 0)
  }
//listForPurchaseFinalisation: Array[Item], cost: Double,customerBuyingTheProducts: Customer, whoAmI: FloorStaff, stock: Stock, summary: SummarySaleRecord, paymentWithPoints: Option[Int] = None
  def finaliseSale(listForPurchaseFinalisation: Array[Item], cost: Double,customerBuyingTheProducts: Customer, whoAmI: FloorStaff, stock: Stock, summary: SummarySaleRecord,shop:Shop, paymentWithPoints: Option[Int] = None): Unit ={
    shop.acceptPayment(listForPurchaseFinalisation,cost,customerBuyingTheProducts,whoAmI,stock,summary,paymentWithPoints)
  }

  def checkAmountInStockForThisID(whichStock:Stock,itemId:Int): Int ={
    whichStock.getAmountOfProductsForThisID(itemId)
  }
}
