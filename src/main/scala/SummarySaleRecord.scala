import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 19/06/2017.
  */
class SummarySaleRecord {
  var collectionOfSaleRecords = new ArrayBuffer[SaleRecord]

  //should work, test when you get here
  def getSaleRecord(receiptID:Int): SaleRecord ={
    collectionOfSaleRecords(collectionOfSaleRecords.indexWhere(salerecord => salerecord.receiptID == receiptID ))
  }

  def addSaleRecord(saleRecordToBeAdded:SaleRecord): Unit ={
    collectionOfSaleRecords+=saleRecordToBeAdded
  }

}
