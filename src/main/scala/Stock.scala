/**
  * Created by Administrator on 19/06/2017.
  */
class Stock() {
  var productPreOrderRequestAmount = collection.mutable.Map[Int, Int]()
  var productQuantity = collection.mutable.Map[Int, Int]()

  def getAmountForThisID(checkAmountForThisID: Int): Int = {
    if (productQuantity.contains(checkAmountForThisID)) productQuantity(checkAmountForThisID)
    else
      0
  }

  def updateStockForID(iDToUpdate: Int, newQuantityToUpdateTo: Int): Unit = {
    productQuantity.update(iDToUpdate, newQuantityToUpdateTo)
  }

  def updatePreOrderForID(preOrderID: Int): Unit = {
    productPreOrderRequestAmount.update(preOrderID, productPreOrderRequestAmount.apply(preOrderID) + 1)
  }

}
