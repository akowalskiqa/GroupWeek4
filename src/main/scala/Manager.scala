/**
  * Created by Administrator on 19/06/2017.
  */
class Manager(name:String,employeeID: Int) extends FloorStaff(name, employeeID){

  override def getName() = name
  override def setName(newName:String) =newName

  override def getEmployeeID: Int = employeeID


  override def openShop(shopToOpen: Shop): Unit = {
    shopToOpen.openShop()
  }

   def predictTomorrowsIncome(summary:SummarySaleRecord):Double={
    summary.getPredictedIncomeForTomorrowBasedOnHistoryProvided()
  }

  override def toString: String = s"$employeeID\t$name"


  //  override def closeShop(shopToClose: Shop): Unit = {
//    shopToClose()
//  }
}


