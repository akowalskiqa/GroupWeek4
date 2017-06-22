import scala.collection.mutable.ArrayBuffer
import org.scalatest.FlatSpec


class ManagerAddEmployeeToSystemTest extends FlatSpec {

  "As a Manager I want to be able to add employee to the system" should "add a new employee from the system" in {
    var shop = new Shop()
    var employee1 = new FloorStaff("Elliot", shop.idGenerator.uniqueEmployeeId)
    var employee2 = new FloorStaff("Dave", shop.idGenerator.uniqueEmployeeId)
    var employeeList = ArrayBuffer(employee1,employee2) // existing list is populated

    var newEmployee = new FloorStaff("NewDude", shop.idGenerator.uniqueEmployeeId)


    employeeList += newEmployee

    assert(employeeList.last == newEmployee)
  }

}
