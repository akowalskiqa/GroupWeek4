import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class Customer(override var name:String, val customerId:Int,var registered:Boolean, var points:Int,var preOrdersMade:ArrayBuffer[Item]) extends Person(name) {

}
