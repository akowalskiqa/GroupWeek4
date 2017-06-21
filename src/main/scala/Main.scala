/**
  * Created by Administrator on 20/06/2017.
  */

object Main {


  def main(args: Array[String]) = {
    var shop = new Shop // should have been "new Shop(stock,summarySaleRecord)" something like that, but discovered it too late

    var currentLoggedInEmployee = new FloorStaff("john",1,1)
    currentLoggedInEmployee.openShop(shop)

  }




}
