import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer
import java.util.Date

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeProduceReceiptTest extends FlatSpec {

 " As an Employee I" should " be able to produce a receipt for a customer" in {
   var shop = new Shop()

   var listOfItemsToBuy :Array[Item] =  Array(shop.item1,shop.item2,shop.item3)
   val customer = new Customer("Dave", 101, false, 0)
   val employee1 = new FloorStaff("Deedee", 102)
   var itemStock: Stock = new Stock()
   itemStock.productQuantity+=(1 -> 5, 2 -> 5, 3 -> 5)
   var summary = new SummarySaleRecord

   employee1.openShop(shop)
   val sellDetails:(Array[Item], Double, Int) = shop.sellThis(listOfItemsToBuy,itemStock)
    employee1.finaliseSale(sellDetails._1,sellDetails._2,customer,employee1,itemStock,summary,shop,Some(sellDetails._3))
  // employee1.finaliseSale(sellDetails._1,sellDetails._2,customer,employee1,itemStock,summary,shop)
   val saleRecord = summary.getSaleRecord(customer.receivedReciptsIDs(0))
   assert(saleRecord.getCustomerID.customerId == customer.customerId)
   assert(saleRecord.getReciptId == customer.receivedReciptsIDs(0))

   //val salesRecord = new SaleRecord(sellDetails._1,sellDetails.._2,today,employee1,customer,4,103)

  // assert( salesRecord.purchaseList === listOfItemsToBuy)

    }
  }

////info("So that they have a record of their purchase ")
//info ("Produce receipt")
//info ("Employees can produce a receipt for customers")
//
//Should ("The employee sell a product")  ("The Employee makes a sale")
//
//
//Then ("The system prints a receipt")
