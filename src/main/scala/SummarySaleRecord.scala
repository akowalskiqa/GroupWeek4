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
  def getSaleRecord2(receiptID:Int): SaleRecord ={
    collectionOfSaleRecords(collectionOfSaleRecords.indexWhere(salerecord => salerecord.receiptID == receiptID ))
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

  //gets average income based on history from datesIncome, before the current DATE(which is now...)
  //checks income for all the days in SummarySaleRecord and calculates based on that, to differentiate for weekly etc, create SummarySaleRecord for week or month etc
  def getPredictedIncomeForTomorrowBasedOnHistoryProvided(): Double ={
    var accumulateTotal:Double = 0
    var amountOfDays = 0
    datesIncome.foreach(date => if(date._1.before(new Date())){
      accumulateTotal+=date._2
      amountOfDays+=1})
    accumulateTotal/amountOfDays
  }
}
