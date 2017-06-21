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
  def sellItem(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): Unit ={
    shop.sellThis(listOfItemsToSell,customerBuyingTheProducts,stock,whoAmI,summary:SummarySaleRecord)
  }
  def checkAmountInStockForThisID(whichStock:Stock,itemId:Int): Int ={
    whichStock.getAmountOfProductsForThisID(itemId)
  }
}
