import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Customer(var name: String, val customerId: Int, var registered: Boolean, var points: Int) extends Person() {

  var preOrdersMade:ArrayBuffer[Item] = new ArrayBuffer[Item]()
  var receivedReciptsIDs:ArrayBuffer[Int] = new ArrayBuffer[Int]()

  override def getName() = name
  override def setName(newName:String) =newName

def preOrders(item:Item): Unit = {
  preOrdersMade += item
}

  def updatePointAmount(number:Int): Unit ={
    points = points+number
  }

  def allocateAReceipt(receipt:Int): Unit = {
    receivedReciptsIDs += receipt
  }

  override def toString: String = s"$customerId\t$name\tRegistered status:$registered\t $points Points Available"

}
