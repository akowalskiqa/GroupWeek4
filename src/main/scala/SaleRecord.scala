/**
  * Created by Administrator on 19/06/2017.
  */

import java.util.Date
class SaleRecord(val purchaseList:Array[Item],val totalCost:Double,val dateSold:Date,val soldBy:FloorStaff,val  soldToCustomer:Customer,val pointsAwarded:Int,val reciptId:Int) {

  def getPurchaseList():Array[Item]={
    purchaseList
  }
  def getTotalCost():Double={
    totalCost
  }
  def getDateSold():Date={
    dateSold
  }
  def getSoldBy():FloorStaff={
    soldBy
  }
  def getCustomerID():Customer={
    soldToCustomer
  }
  def getPointsAwarded():Int={
    pointsAwarded
  }
  def getReciptId():Int={
    reciptId
  }
}
