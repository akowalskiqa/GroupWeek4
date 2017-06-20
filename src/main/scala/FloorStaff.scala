/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(// var employeeID: Int
                ) extends Person {

 // def getEmpID(): Int = {employeeID}
 // def setEmpID(newEmpID: Int): Unit = {employeeID = newEmpID}
  //def employeeId:Int
  //def authorityLevel:Int

  def openShop(shopToOpen: Shop,myself:Person): Unit ={
    shopToOpen.openShop(myself)
  }

}
