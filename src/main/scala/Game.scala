/**
  * Created by Administrator on 19/06/2017.
  */
class Game( itemID:Int, name:String, price:Double, pointValue:Int,var preOrder:Boolean) extends Item(itemID,name,price,pointValue) {
  def getPreOrderAvailability():Boolean={preOrder}
  def setPreOrderAvailability(status:Boolean):Unit={preOrder=status}

}
