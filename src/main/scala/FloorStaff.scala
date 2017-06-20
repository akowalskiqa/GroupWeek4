/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(val nameA:String,var employeeID: Int,var authorityLevel:Int) extends Person(nameA) {

 // def getEmpID(): Int = {employeeID}
 // def setEmpID(newEmpID: Int): Unit = {employeeID = newEmpID}
  //def employeeId:Int
  //def authorityLevel:Int

  def openShop(shopToOpen: Shop,myself:Person): Unit ={
    shopToOpen.openShop(myself)
  }

  def closeShop(shopToClose : Shop): {
  shopToClos
  }

}
