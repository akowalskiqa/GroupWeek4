/**
  * Created by Administrator on 19/06/2017.
  */
class Game(var itemID: Int, var name: String, var price: Double, var pointValue: Int,var preOrder: Boolean) extends Item() {
  def getPreOrderAvailability():Boolean={preOrder}
  def setPreOrderAvailability(status:Boolean):Unit={preOrder=status}

  override def getItemID(): Int = itemID

  override def getItemName(): String = name

  override def getItemPrice(): Double = price

  override def getItemPointValue(): Int = pointValue

}
