/**
  * Created by Administrator on 20/06/2017.
  */

object Main {


  def main(args: Array[String]) = {
    var shop = new Shop // should have been "new Shop(stock,summarySaleRecord)" something like that, but discovered it too late

    var currentLoggedInEmployee = new FloorStaff("john", 1)
    currentLoggedInEmployee.openShop(shop)

    login()


  def login(): Unit = {
    println("Press 1: Manager\nPress 2: Floor Staff\nPress 0: Exit System")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => sys.exit()
      case "1" => println("Welcome Manager"); managerMenu()
      case "2" => println("Welcome Floor Staff"); floorStaffMenu()
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); login()
    }
  }

  def floorStaffMenu(): Unit = {

    println("Press 1: Transaction\nPress 2: Open Shop\nPress 3: Close Shop\nPress 4: Daily Figures\nPress 5: Log out")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "1" => println("Transaction Screen"); floorStaffTransaction()
      case "2" => println("Shop Opened"); floorStaffMenu() // Add Function/
      case "3" => println("Shop Closed"); sys.exit()
      case "4" => println("Daily Figures: ") //Ad Function
      case "5" => login()
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffMenu()
    }

  }

  def floorStaffTransaction(): Unit = {
    println("Press 1: Add by ID\nPress 2: Show basket\nPress 3: Checkout\nPress 4: List stock\nPress 5: Clear basket\nPress 0: Go back to menu")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => floorStaffMenu()
      case "1" => println("Add by ID function")
      case "2" => println("Show basket")
      case "3" => println("Checkout")
      case "4" => println("List stock")
      case "5" => println("Clear basket")
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffTransaction()
    }

  }

  def floorStaffCheckout(): Unit = {
    println("Press 1: Pay with cash\nPress 2: Pay with points\nPress 0: Go back to menu")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => floorStaffMenu()
      case "1" => println("Pay with cash")
      case "2" => println("Pay with points")
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); floorStaffCheckout()
    }

  }


  def managerMenu(): Unit = {
    println("Press 1: Stock\nPress 2: Employee\nPress 3: Sales\nPress 4: Log out\nPress 0: Exit system")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => sys.exit()
      case "1" => stockManager()
      case "2" => employeeManager()
      case "3" => managerSales()
      case "4" => login()
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); managerMenu()
    }
  }

  def stockManager(): Unit = {
    println("Press 1: Add item to stock list\nPress 2: Update item details\nPress 3: Delete item\nPress 4: Update quantity\nPress 0: Back to menu")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => managerMenu()
      case "1" => println("Add item to stock list")
      case "2" => println("Update item details")
      case "3" => println("Delete item")
      case "4" => println("Update quantity")
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); scanner
    }
  }

  def employeeManager(): Unit = {
    println("Press 1: Add Floor staff\nPress 2: Delete floor staff\nPress 0: Back to menu")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => managerMenu()
      case "1" => println("Add floorstaff function")
      case "2" => println("Delete floorstaff function")
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); employeeManager()
    }
  }

  def managerSales(): Unit = {
    println("Press 1: Previous figures\nPress 2: Current figures\nPress 3: Future figures\nPress 0: Back to menu")
    var scanner = scala.io.StdIn.readLine()

    scanner match {
      case "0" => managerMenu()
      case "1" => println("Previous figures function")
      case "2" => println("Current figures function")
      case "3" => println("Future figures function")
      case _ => println("Error - Incorrect key pressed\nReturned to current page"); managerSales()
    }
  }

  }

}
