import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Profile on 20/06/2017.
  */
class EmployeeProduceReceiptTest extends FlatSpec {

 " As an Employee I" should " produce a receipt for a customer" in {
   var shop = new Shop()

   var listOfItemsToBuy :Array[Item] =  Array(shop.item1,shop.item2,shop.item3)

   var itemStock: Stock = new Stock()
   itemStock.productQuantity+=(1->5),(2->5),(3->5)

   shop.sellThis(listOfItemsToBuy,itemStock)

   val salesRecord = new SaleRecord(listOfItemsToBuy,_,_,_,_,_,_)
  // assert (receipt.test == )
   assert(salesRecord.getPurchaseList == listOfItemsToBuy)
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
