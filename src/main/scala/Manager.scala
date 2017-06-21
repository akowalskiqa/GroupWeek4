/**
  * Created by Administrator on 19/06/2017.
  */
class Manager(override var name: String, override val employeeID: Int,override var authorityLevel: Int) extends FloorStaff(name, employeeID, authorityLevel){

  override def getName() = name
  override def setName(newName:String) =newName

  override def getEmployeeID: Int = employeeID

  override def getAuthorityLevel: Int = authorityLevel

  override def setAuthorityLevel(newAuthlevel: Int): Unit = {
    authorityLevel = newAuthlevel
  }


  override def openShop(shopToOpen: Shop, myself: Person): Unit = {
    shopToOpen.openShop(myself)
  }

  override def closeShop(shopToClose: Shop): Unit = {
    shopToClose
  }
}


