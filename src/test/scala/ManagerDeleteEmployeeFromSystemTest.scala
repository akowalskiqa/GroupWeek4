import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

//working
class ManagerDeleteEmployeeFromSystemTest extends FlatSpec {
  "As a Manager I want to be able to Delete employee to the system" should "Delete an employee from the system" in {
      var shop = new Shop()
      var employee1 = new FloorStaff("Fred", shop.idGenerator.uniqueEmployeeId)
      shop.createAnFloorStaff(employee1)
      shop.deleteAnFloorStaff(employee1.employeeID)
      assert(shop.listOfFLoorStaff.last !== employee1)
    }
  }