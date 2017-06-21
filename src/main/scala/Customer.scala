import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Customer( name:String, val customerId:Int,var registered:Boolean, var points:Int,var preOrdersMade:ArrayBuffer[Item],var receivedReceiptsIDs:ArrayBuffer[Int]) extends Person(name) {


  def updatePointAmount(number:Int): Unit ={
    points = points+number
  }

  def allocateAReceipt(receipt:Int): Unit ={
    receivedReceiptsIDs +=receipt
  }

}
