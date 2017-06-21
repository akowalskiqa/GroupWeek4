import scala.collection.mutable.ArrayBuffer
import java.util.Date

/**
  * Created by Administrator on 19/06/2017.
  */
class SummarySaleRecord {
  var collectionOfSaleRecords = new ArrayBuffer[SaleRecord]
  var datesIncome = collection.mutable.Map[Date,Double]()

  //should work, test when you get here
  def getSaleRecord(receiptID:Int): SaleRecord ={
    collectionOfSaleRecords.filter(record => record.receiptID==receiptID)
    collectionOfSaleRecords(0)
  }

  def addSaleRecord(saleRecordToBeAdded:SaleRecord): Unit ={
    collectionOfSaleRecords+=saleRecordToBeAdded
  }

  def updateDatesIncome(when:Date,amount:Double): Unit ={
    if(datesIncome.contains(when)){
      val current = datesIncome(when)
      datesIncome.put(when,current+amount)
    }
  }
  def getDatesIncome(when:Date): Double ={
    datesIncome(when)
  }
}
