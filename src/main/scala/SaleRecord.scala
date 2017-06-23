/**
  * Created by Administrator on 19/06/2017.
  */

import java.util.Date

import PersonType.PersonType

class SaleRecord(val purchaseList: Array[Item], val totalCost: Double, val dateSold: Date, val soldBy: FloorStaff, val soldToCustomer: Customer, val pointsAwarded: Int, val receiptID: Int) {

  def getPurchaseList: Array[Item] = purchaseList


  def getTotalCost: Double = {
    totalCost
  }

  def getDateSold: Date = {
    dateSold
  }

  def getSoldBy: FloorStaff = {
    soldBy
  }

  def getCustomerID: Customer = {
    soldToCustomer
  }

  def getPointsAwarded: Int = {
    pointsAwarded
  }

  def getReciptId: Int = {
    receiptID
  }
  def getPurchasedList:Array[Item]={
    purchaseList
  }

  override def toString: String = {
    "Reciept ID: "+receiptID +"\n"+purchaseList.mkString("\n") +"\n" +"Customer: "+soldToCustomer.getId()+" \n" +  " \n" +dateSold+"\n" + soldBy.toString+"\n" +totalCost + " \n" + pointsAwarded+" \n"
  }
}
