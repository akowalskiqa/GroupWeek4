import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer
import java.util.Date

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeProduceReceiptTest extends FlatSpec {

 " As an Employee I" should " be able to produce a receipt for a customer" in {
   var shop = new Shop()
   shop.openShop()
   val today:Date = new java.util.Date

   var listOfItemsToBuy :Array[Item] =  Array(shop.item1,shop.item2,shop.item3)
   val customer = new Customer("Dave", 101, false, 0)
   val employee1 = new FloorStaff("Deedee", 102)
   var itemStock: Stock = new Stock()
   itemStock.productQuantity+=(1 -> 5, 2 -> 5, 3 -> 5)

   val sellDetails = shop.sellThis(listOfItemsToBuy,itemStock)

   val salesRecord = new SaleRecord(sellDetails.get._1,sellDetails.get._2,today,employee1,customer,4,103)

   assert( salesRecord.purchaseList === listOfItemsToBuy)

    }
  }

