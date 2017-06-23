/**
  * Created by Administrator on 19/06/2017.
  */
class Hardware(var itemID: Int, var name: String, var price: Double, var pointValue: Int) extends Item() {

  def getItemID(): Int = itemID

  def getItemName(): String = name

  def getItemPrice(): Double = price

  def getItemPointValue(): Int = pointValue

  override def setItemName(newName: String): Unit = name = newName

  override def setItemPrice(newPrice: Double): Unit = price=  newPrice

  override def setItemPointValue(newPointValue: Int): Unit = pointValue =newPointValue

  override def toString: String = itemID + "\t" + name +"\t"+ f"£$price%2.2f"+s"\t$pointValue Point(s)"
}
