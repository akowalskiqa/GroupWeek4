/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(var name: String, val employeeID: Int) extends Person() {

  override def getName() = name
  override def setName(newName:String) =newName

  def getEmployeeID: Int = employeeID


  def openShop(shopToOpen: Shop, myself: Person): Unit = {
    shopToOpen.openShop(myself)
  }

  def closeShop(shopToClose: Shop): Unit = {
    shopToClose
  }

  def sellItem(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): Unit ={
    shop.sellThis(listOfItemsToSell,customerBuyingTheProducts,stock,whoAmI,summary:SummarySaleRecord)
  }
}
