/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(name:String,val employeeID: Int,var authorityLevel:Int) extends Person(name) {
  require(0<=authorityLevel&&authorityLevel<=2)
  def getEmployeeID():Int={employeeID}
  def getAuthorityLevel():Int={authorityLevel}
  def setAuthoityLevel(newAuthlevel:Int):Unit={authorityLevel=newAuthlevel}



  def openShop(shopToOpen: Shop,myself:Person): Unit ={
    shopToOpen.openShop(myself)
  }

  def closeShop(shopToClose : Shop):Unit ={
  //shopToClose
  }

  def sellItem(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): Unit ={
    shop.sellThis(listOfItemsToSell,customerBuyingTheProducts,stock,whoAmI,summary:SummarySaleRecord)
  }
}
