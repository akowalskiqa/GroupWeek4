import org.scalatest._
import scala.collection.mutable.ArrayBuffer
/**
  * Created by Administrator on 20/06/2017.
  */
class ShopTest extends FlatSpec {

 " As an Employee *I wish to close the shop and tally a day's profit" should "Employee close the shop" in {
   val employee = new FloorStaff("john", 1)
   val shop = new Shop
   shop.openShop()

   var store = new SummarySaleRecord()
   shop.closeShop(store)
   assert(!shop.openStatus)
 }

 it should "open the days tally counter at start of 0" in{
      val shop = new Shop()
      shop.openShop()
      assert(shop.todaysIncomeTally == 0)
    }
}
