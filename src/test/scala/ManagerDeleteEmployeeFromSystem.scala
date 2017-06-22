import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 22/06/2017.
  */
class ManagerDeleteEmployeeFromSystem extends FlatSpec{

  "As a Manager I want to be able to add a new employee to the system" should "Add a new employee" in {
    var shop = new Shop()
    var employee1 = shop.listOfFLoorStaff(1)


    var item1 = shop.defineAnItem(ItemTypes.Game, "Mass Effect", 15.0, 10)

    var itemlist: ArrayBuffer[Item] = ArrayBuffer()

    itemlist += item1

    assert(itemlist.last == item1)
  }



}
