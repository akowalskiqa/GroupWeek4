/**
  * Created by Administrator on 19/06/2017.
  */
abstract class Item() {

  def getItemID(): Int

  def getItemName(): String

  def getItemPrice(): Double

  def getItemPointValue(): Int

  def setItemName(newName: String): Unit = newName

  def setItemPrice(newPrice: Double): Unit = newPrice

  def setItemPointValue(newPointValue: Int): Unit = newPointValue
}
