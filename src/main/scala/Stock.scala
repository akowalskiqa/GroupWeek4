/**
  * Created by Administrator on 19/06/2017.
  */
class Stock() {
  var productPreOrderRequestAmount = collection.mutable.Map[Int, Int]()
  var productQuantity = collection.mutable.Map[Int,Int]()

  //view Stock
  def getAmountForThisID(checkAmountForThisID:Int):Option[Int]={
    productQuantity.get(checkAmountForThisID)

  }

  def updateStockForID(iDToUpdate:Int, newQuantityToUpdateTo:Int):Unit={
      //productQuantity.getAmountForThisID(iDToUpdate)
   var store =  productQuantity.get(iDToUpdate)
    store= store += newQuantityToUpdateTo



  }

  def getPreOrder(preOrderId:Int):Unit={
    productPreOrderRequestAmount.get(productPreOrderRequestAmount)
  }
  //add to PreOrderRequestAmount extra preorder request for according item Id(key)
  //update amount in productQuantity
}
