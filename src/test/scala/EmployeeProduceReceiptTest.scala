import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer
import java.util.Date

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeProduceReceiptTest extends FlatSpec {
//done
 " As an Employee I" should " be able to produce a receipt for a customer and pay with points" in {
   var shop = new Shop()

   var listOfItemsToBuy :Array[Item] =  Array(shop.item1,shop.item2,shop.item3,shop.item2)
   val customer = new Customer("Dave", 101, false, 50)
   val employee1 = new FloorStaff("Deedee", 102)
   var itemStock: Stock = new Stock()
   itemStock.productQuantity+=(1 -> 5, 2 -> 5, 3 -> 5)
   var summary = new SummarySaleRecord
   shop.listOfCustomers+=customer
   val beforePurchase =  shop.listOfCustomers((shop.listOfCustomers.indexOf(customer))).getPointsAmount()
   employee1.openShop(shop)
   val sellDetails:(Array[Item], Double, Int) = shop.sellThis(listOfItemsToBuy,itemStock)
   employee1.finaliseSale(sellDetails._1,sellDetails._2,customer,employee1,itemStock,summary,shop,Some(sellDetails._3))
   //employee1.finaliseSale(sellDetails._1,sellDetails._2,customer,employee1,itemStock,summary,shop)
   val saleRecord = summary.getSaleRecord(customer.receivedReciptsIDs(0))
   println(saleRecord.printContent())

   assert(saleRecord.getCustomerID.customerId == customer.customerId)
   assert(saleRecord.getReciptId == customer.receivedReciptsIDs(0))
   assert(shop.listOfCustomers((shop.listOfCustomers.indexOf(customer))).getPointsAmount() ==(beforePurchase-sellDetails._3))
    }
  }
