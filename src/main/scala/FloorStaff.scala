/**
  * Created by Administrator on 19/06/2017.
  */
class FloorStaff(var name: String, val employeeID: Int, var authorityLevel: Int) extends Person() {
  require(0 <= authorityLevel && authorityLevel <= 2)

  override def getName() = name
  override def setName(newName:String) =newName

  def getEmployeeID: Int = employeeID

  def getAuthorityLevel: Int = authorityLevel

  def setAuthorityLevel(newAuthlevel: Int): Unit = {
    authorityLevel = newAuthlevel
  }


  def openShop(shopToOpen: Shop, myself: Person): Unit = {
    shopToOpen.openShop(myself)
  }

  def closeShop(shopToClose: Shop): Unit = {
    shopToClose
  }

  //def sellItem()
}
