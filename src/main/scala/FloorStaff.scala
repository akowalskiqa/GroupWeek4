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
  def sellItem(listOfItemsToSell:Array[Item],customerBuyingTheProducts:Customer,shop:Shop,stock:Stock,whoAmI:FloorStaff,summary:SummarySaleRecord): (Array[Item], Double, Int) ={
    shop.sellThis(listOfItemsToSell,stock) //getOrElse  (Array[Item](), 0, 0)
  }
//listForPurchaseFinalisation: Array[Item], cost: Double,customerBuyingTheProducts: Customer, whoAmI: FloorStaff, stock: Stock, summary: SummarySaleRecord, paymentWithPoints: Option[Int] = None
  def finaliseSale(listForPurchaseFinalisation: Array[Item], cost: Double,customerBuyingTheProducts: Customer, whoAmI: FloorStaff, stock: Stock, summary: SummarySaleRecord,shop:Shop, paymentWithPoints: Option[Int] = None): Unit ={
    shop.acceptPayment(listForPurchaseFinalisation,cost,customerBuyingTheProducts,whoAmI,stock,summary,paymentWithPoints)
  }

  def checkAmountInStockForThisID(whichStock:Stock,itemId:Int): Int ={
    whichStock.getAmountOfProductsForThisID(itemId)
  }

  override def toString: String = s"$employeeID\t$name"
}
