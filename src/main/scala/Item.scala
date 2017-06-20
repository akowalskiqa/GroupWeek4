/**
  * Created by Administrator on 19/06/2017.
  */
abstract class Item(val itemID: Int,var name:String,var price:Double,var pointValue:Int){
  val shop = new Shop
  def getItemID(): Int = shop.idGenerator.uniqueItemId
  def getItemName():String={name}
  def getItemPrice():Double = {price}
  def getItemPointValue():Int={pointValue}

  def setItemName(newName:String):Unit={name=newName}
  def setItemPrice(newPrice:Double):Unit={price=newPrice}
  def setItemPointValue(newPointValue:Int):Unit={pointValue=newPointValue}
}
