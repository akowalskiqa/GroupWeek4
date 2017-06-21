/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(var name: String, val employeeID: Int) extends Person() {

  override def getName() = name

  override def setName(newName: String) = newName

  def getEmployeeID: Int = employeeID


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
