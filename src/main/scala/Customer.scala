import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Customer(var name: String, val customerId: Int, var registered: Boolean, var points: Int) extends Person() {

  var preOrdersMade:ArrayBuffer[Item] = null
  var receivedReciptsIDs:ArrayBuffer[Int] = null

  override def getName() = name
  override def setName(newName:String) =newName

def preOrders(item:Item): Unit = {
  preOrdersMade += item
}
  def receivedRecipts(rec:Int): Unit = {
    receivedReciptsIDs += rec
  }

}
