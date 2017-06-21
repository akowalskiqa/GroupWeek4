import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class SummarySaleRecord {
  var collectionOfSaleRecords = new ArrayBuffer[SaleRecord]

  //should work, test when you get here
  def getSaleRecord(receiptID:Int): SaleRecord ={
    collectionOfSaleRecords.filter(record => record.receiptID==receiptID)
    collectionOfSaleRecords(0)
  }

  def addSaleRecord(saleRecordToBeAdded:SaleRecord): Unit ={
    collectionOfSaleRecords+=saleRecordToBeAdded
  }

}
