/**
  * Created by Administrator on 19/06/2017.
  */
class Misc(var itemID: Int, var name: String, var price: Double, var pointValue: Int) extends Item(){

  override def getItemID(): Int = itemID

  override def getItemName(): String = name

  override def getItemPrice(): Double = price

  override def getItemPointValue(): Int = pointValue
}