import scala.collection.mutable.ArrayBuffer
import org.scalatest.FlatSpec


class ManagerAddEmployeeToSystemTest extends FlatSpec {

  "As a Manager I want to be able to add employee to the system" should "add a new employee from the system" in {
    var shop = new Shop()
    var newEmployee = new FloorStaff("NewDude", shop.idGenerator.uniqueEmployeeId)
    shop.createAnFloorStaff(newEmployee)
    assert(shop.listOfFLoorStaff.last === newEmployee)
  }
}
