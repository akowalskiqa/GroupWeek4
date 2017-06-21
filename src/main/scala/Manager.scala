/**
  * Created by Administrator on 19/06/2017.
  */
class Manager(name:String,employeeID: Int) extends FloorStaff(name, employeeID){

  override def getName() = name
  override def setName(newName:String) =newName

  override def getEmployeeID: Int = employeeID


  override def openShop(shopToOpen: Shop, myself: Person): Unit = {
    shopToOpen.openShop(myself)
  }

  override def closeShop(shopToClose: Shop): Unit = {
    shopToClose
  }
}


