import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Customer(var name:String, val customerId:Int,var registered:Boolean, var points:Int,var preOrdersMade:ArrayBuffer[Item],var receivedReciptsIDs:ArrayBuffer[Int]) extends Person() {

  override def getName() = name
  override def setName(newName:String) =newName

}
