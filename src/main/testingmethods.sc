import java.text.SimpleDateFormat

import scala.collection.mutable.ArrayBuffer
import java.util.Date



def callThis() {
  var datesIncome = collection.mutable.Map[Date, Double]()

  datesIncome.put(new Date("Fri Oct 31 15:07:24 2014"), 2.23)
  datesIncome.put(new Date("Fri Oct 21 15:07:24 2014"), 1.00)
  datesIncome.put(new Date("Fri Oct 11 15:07:24 2014"), 5.00)

  var accumulateTotal: Double = 0
  var amountOfDays = 0

  datesIncome.foreach(date => if (date._1.before(new Date())) {
    accumulateTotal += date._2;
    amountOfDays += 1
  })
  println(accumulateTotal)
  var print: Double = (accumulateTotal / amountOfDays)
  println(print)

}
callThis()




var map = collection.mutable.Map[Int, Int]()

map.put(5,5)
map.put(2,5)
map.put(1,5)
map.put(3,5)

map.foreach {keyVal => println(keyVal._1 + "=" + keyVal._2)}
map.put(1,map(1)-1)
map.foreach {keyVal => println(keyVal._1 + "=" + keyVal._2)}










val dateFormat = new SimpleDateFormat("dd/MM/yyyy").format(new Date())
//println(dateFormat.format(dateFormat.parse()))


println((new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()).format()))



//System.out.println(dateFormat.format(dateFormat.parse("31/05/2011")))


//new java.util.Date()


//df.select(df("ID"), date_format(df("Week_Ending_Date"), "yyyy-MM-dd")) .filter(date_format(df("Week_Ending_Date"), "yyyy-MM-dd").between("2015-07-05", "2015-09-02"))