/**
  * Created by Administrator on 20/06/2017.
  */

object Main {


  def main(args: Array[String]) = {
    var shop = new Shop
    var currentLoggedInEmployee = new FloorStaff
    currentLoggedInEmployee.openShop(shop,currentLoggedInEmployee)
  }
}
