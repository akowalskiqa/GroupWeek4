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

  override def setItemName(newName: String): Unit = name = newName

  override def setItemPrice(newPrice: Double): Unit = price=  newPrice

  override def setItemPointValue(newPointValue: Int): Unit = pointValue =newPointValue

  override def toString: String = itemID + "\t" + name +"\t"+ f"£$price%2.2f"+s"\t$pointValue Point(s)"

}
