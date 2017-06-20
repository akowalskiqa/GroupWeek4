/**
  * Created by Administrator on 19/06/2017.
  */
abstract class Item(var itemID: Int) {

  def getID(): Int = {itemID}
  def setID(newID: Int): Unit = {itemID = newID}
  //def id:Int
  def name:String
  def price: Double
  def pointValue:Int

}
