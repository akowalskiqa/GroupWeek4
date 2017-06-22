import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 22/06/2017.
  */
class ManagerAddEmployeeToSystemTest extends FlatSpec{
  "As a Manager I want to be able to add an employee to the system" should "Add an employee" in {
    var shop = new Shop()
    var employee1 = new FloorStaff("Fred", shop.idGenerator.uniqueEmployeeId)
    shop.createAnFloorStaff(employee1)
    assert(shop.listOfFLoorStaff.last == employee1)
  }
}
