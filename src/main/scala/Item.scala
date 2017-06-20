/**
  * Created by Administrator on 19/06/2017.
  */
abstract class Item(var itemID: Int, name: String) {

  def getID(): Int = {itemID}
  def setID(newID: Int): Unit = {itemID = newID}
  def getName(): String = {name}
  //def id:Int
  //def name:String
  //def price: Double
  //def pointValue:Int

}
