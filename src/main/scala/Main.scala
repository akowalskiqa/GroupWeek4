import PersonType.PersonType

/**
  * Created by Administrator on 20/06/2017.
  */

object Main {


  def main(args: Array[String]) = {
    var shop = new Shop // should have been "new Shop(stock,summarySaleRecord)" something like that, but discovered it too late
    var saleSum = new SummarySaleRecord

    var currentLoggedInEmployee = new FloorStaff("john", 1)
    currentLoggedInEmployee.openShop(shop)

    login()


    def elliot(): Unit = {
      println("\n  ______ _ _ _       _              ______    _                _     \n |  ____| | (_)     | |     ___    |  ____|  (_)              | |    \n | |__  | | |_  ___ | |_   ( _ )   | |__ _ __ _  ___ _ __   __| |____\n |  __| | | | |/ _ \\| __|  / _ \\/\\ |  __| '__| |/ _ \\ '_ \\ / _` |_  /\n | |____| | | | (_) | |_  | (_>  < | |  | |  | |  __/ | | | (_| |/ / \n |______|_|_|_|\\___/ \\__|  \\___/\\/ |_|  |_|  |_|\\___|_| |_|\\__,_/___|\n                                                                     \n                                                                     ")
    }

    def login(): Unit = {
      elliot()
      println("Press 1: Manager\nPress 2: Floor Staff\nPress 0: Exit System")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => sys.exit()
          case "1" => println("Welcome Manager"); managerMenu()
          case "2" => println("Welcome Floor Staff"); floorStaffMenu()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); login()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); login()
        }
    }

    def floorStaffMenu(): Unit = {

      println("Press 1: Transaction\nPress 2: Open \nPress 3: Close Shop\nPress 4: Daily Figures\nPress 5: Log out")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "1" => println("Transaction Screen"); floorStaffTransaction()
          case "2" => if(shop.openStatus) {
            println("Store already opened")

          }
          else {
            println("Shop Opened")
            shop.openShop();
          }; floorStaffMenu()
          case "3" => println("Shop Closed"); shop.closeShop(saleSum); login()
          case "4" => println("Daily Figures: "); println(saleSum.datesIncome.mkString(""))
          case "5" => login()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffMenu()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); floorStaffMenu()
        }

    }

    def floorStaffTransaction(): Unit = {
      println("Press 1: Add item to basket by item ID\nPress 2: Show basket\nPress 3: Checkout\nPress 4: List stock\nPress 5: Clear basket\n" +
        "Press 6: Remove item from the basket\nPress 0: Go back to menu")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => floorStaffMenu()
          case "1" => println("Enter ID for item you adding to basket: "); var scanner = scala.io.StdIn.readLine(); shop.addItemToShoppingBasket(scanner.toInt); floorStaffTransaction()
          case "2" => println(shop.listOfItemsToSell.mkString("\n")); floorStaffTransaction()
          case "3" =>
            var saleDetails = shop.sellThis(shop.listOfItemsToSell.toArray, shop.listOfStock)
            println(saleDetails._1.mkString + saleDetails._2 + saleDetails._3);floorStaffCheckout()
          case "4" => println(shop.listOfItems.mkString("\n")); floorStaffTransaction()
          case "5" => println("Clearing basket..."); shop.clearShoppingBasket(); floorStaffTransaction()
          case "6" => println("Enter ID for item you're removing from basket: "); var scanner = scala.io.StdIn.readLine(); shop.removeItemById(scanner.toInt); floorStaffTransaction()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffTransaction()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); floorStaffTransaction()
        }

    }

    def floorStaffCheckout(): Unit = {
      println("Press 1: Pay with cash\nPress 2: Pay with points\nPress 0: Go back to menu")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => floorStaffMenu()
          case "1" => println("Pay with cash")
          case "2" => println("Pay with points")
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffCheckout()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); floorStaffCheckout()
        }

    }


    def managerMenu(): Unit = {
      println("Press 1: Stock\nPress 2: Employee\nPress 3: Sales\nPress 4: Log out\nPress 0: Exit system")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => sys.exit()
          case "1" => stockManager()
          case "2" => employeeManager();
          case "3" => managerSales()
          case "4" => login()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); managerMenu()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); managerMenu()
        }
    }

    def stockManager(): Unit = {
      println("Press 1: Add item to item list\nPress 2: Update item details\nPress 3: Delete item\nPress 4: Update stock quantity\nPress 0: Back to menu")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => managerMenu()
          case "1" => println("Enter Item Type: ");
            var itemType = scala.io.StdIn.readLine();
            println("Enter Item Name: ");
            var itemName = scala.io.StdIn.readLine();
            stockManager()
            println("Enter Item Price: ");
            var itemPrice = scala.io.StdIn.readLine();
            println("Enter Amount of points for item: ");
            var itemPoints = scala.io.StdIn.readLine();
            stockManager()
            println("Is item for pre-order [True/False]: ");
            var itemPreorder = scala.io.StdIn.readLine(); //shop.defineAnItem(itemType = itemType, itemName, itemPrice.toDouble, itemPoints.toInt, itemPreorder.toBoolean)
          case "2" => println("Update item details"); stockManager()
          case "3" => println("Enter ID for item you're deleting: "); var scanner = scala.io.StdIn.readLine(); shop.deleteAnItem(scanner.toInt); stockManager()
          case "4" => println("Enter ID for item you're updating stock quantity: "); var itemID = scala.io.StdIn.readLine(); println("Enter new stock quantity number: "); var quantity = scala.io.StdIn.readLine(); shop.updateStockForID(itemID.toInt, quantity.toInt); stockManager()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); stockManager()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); stockManager()
        }
    }

    def employeeManager(): Unit = {
      println("Press 1: Add Floor staff\nPress 2: Delete floor staff\nPress 3: View Floor staff Employee details\nPress 4: View Employee listing\nPress 5: Update Employee record\nPress 0: Back to menu")
      var scanner = scala.io.StdIn.readLine()
      var employeeType:PersonType = PersonType.Manager
      try {
        scanner match {
          case "0" => managerMenu()
          case "1" => println("Enter the name of the floor staff you're adding: ");
            var floorstaffname = scala.io.StdIn.readLine();
            println("Enter employee type: \nPress 1: Manager\nPress 2: Floor Staff");
            var personType = scala.io.StdIn.readLine();
            personType match {
              case "1" => employeeType = PersonType.Manager
              case "2" => employeeType = PersonType.FloorStaff
              case _ => println("Error"); employeeManager()
            }
            println("Enter the floorstaff ID: ");
            var floorstaffid = scala.io.StdIn.readLine()
            shop.createAnFloorStaff(shop.defineAnPersonType(employeeType, floorstaffname, floorstaffid.toInt));
            employeeManager()
          case "2" => println("Enter the Floor Staff ID that you want to delete: "); var scanner = scala.io.StdIn.readLine(); shop.deleteAnFloorStaff(scanner.toInt); employeeManager()
          case "3" => println("Enter Floor Staff ID you want to view: "); var scanner = scala.io.StdIn.readLine(); println(" " + shop.readAnFloorStaff(scanner.toInt)); employeeManager()
          case "4" => println(shop.listOfFLoorStaff.mkString("\n")); employeeManager()
          case "5" => println("Enter the Employee ID you want to update: ");
            var employeeid = scala.io.StdIn.readLine();
            println("Enter employee type: \nPress 1: Manager\nPress 2: Floor Staff");
            var personType = scala.io.StdIn.readLine();
            personType match {
              case "1" => employeeType = PersonType.Manager
              case "2" => employeeType = PersonType.FloorStaff
              case _ => println("Error"); employeeManager()
            };
            println("Enter the updated name for the Employee you wish to update record: ");
            var employeeNewName = scala.io.StdIn.readLine();
            shop.updateAnFloorStaff(employeeid.toInt, employeeType, employeeNewName);
            employeeManager()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); employeeManager()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); employeeManager()
        }
    }

    def managerSales(): Unit = {
      println("Press 1: Previous figures\nPress 2: Current figures\nPress 3: Future figures\nPress 0: Back to menu")
      var scanner = scala.io.StdIn.readLine()
      try {
        scanner match {
          case "0" => managerMenu()
          case "1" => println("Enter the date you want to view figure for: "); var date = scala.io.StdIn.readLine(); //saleSum.getDatesIncome()
          case "2" => println("Current figure: " + shop.todaysIncomeTally); managerSales()
          case "3" => println("Predicted income for tomorrow: " + saleSum.getPredictedIncomeForTomorrowBasedOnHistoryProvided()); managerSales()
          case _ => println("Error - Incorrect key pressed\nReturned to current page"); managerSales()
        }
      }
      catch
        {
          case _: Throwable => println("Error, Please try again!"); managerSales()
        }
    }

  }
}
