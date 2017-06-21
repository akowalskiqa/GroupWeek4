/**
  * Created by Administrator on 19/06/2017.
  */
class Stock() {
  var productPreOrderRequestAmount = collection.mutable.Map[Int, Int]()
  var productQuantity = collection.mutable.Map[Int,Int]()

  def getAmountOfProductsForThisID(checkAmountForThisID:Int):Option[Int]={
    productQuantity.get(checkAmountForThisID)
  }

  def updateStockForID(iDToUpdate:Int, newQuantityToUpdateTo:Int):Unit={
    if(productQuantity.contains(iDToUpdate)) {
      val store = productQuantity(iDToUpdate)
      productQuantity.put(iDToUpdate, store + newQuantityToUpdateTo)
    }else{
      productQuantity.put(iDToUpdate,newQuantityToUpdateTo)
    }
  }

  def addPreOrderToThisItem(preOrderId:Int):Unit={
    if(productPreOrderRequestAmount.contains(preOrderId)){
      val current = productPreOrderRequestAmount(preOrderId)
      productPreOrderRequestAmount.put(preOrderId,current+1)
    }else{
      productPreOrderRequestAmount.put(preOrderId,1)
    }
  }

  def getPreOrderAmountForThisItem(preOrderId:Int): Unit ={
    if(productPreOrderRequestAmount.contains(preOrderId)) {
      productPreOrderRequestAmount(preOrderId)
    }
  }
}
