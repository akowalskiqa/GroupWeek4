import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import FirstPage.stage

import scalafx.Includes._
import MenuPage.stage
import com.sun.java.swing.plaf.gtk.GTKConstants.Orientation

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.event.ActionEvent


object Main extends JFXApp{

  stage = new PrimaryStage {
    title = "First GUI"
    scene = new Scene(1550, 750) {

      val rb1 = new RadioButton("Manager")
      rb1.layoutY = 5
      rb1.layoutX = 600

      val rb2 = new RadioButton("Employee")
      rb2.layoutY = 5
      rb2.layoutX = 750
      val toggle1 = new ToggleGroup
      toggle1.toggles = List(rb1, rb2)


      var listView = new ListView(List("Test 1-------------------------------------------------",
        "Test2", "Test3", "Test4", "Test5", "Test 1", "Test2", "Test3", "Test4", "Test5", "Test 1",
        "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView.layoutX = 25
      listView.layoutY = 25
      listView.prefHeight = 250
      listView.prefWidth = 275

      val button1 = new Button("Button1")
      button1.layoutX = 25
      button1.layoutY = 300

      val button2 = new Button("Button2")
      button2.layoutX = 100
      button2.layoutY = 300

      val button3 = new Button("Button3")
      button3.layoutX = 175
      button3.layoutY = 300

      val button4 = new Button("Button4")
      button4.layoutX = 25
      button4.layoutY = 340

      val button5 = new Button("Button5")
      button5.layoutX = 100
      button5.layoutY = 340

      val button6 = new Button("Button6")
      button6.layoutX = 175
      button6.layoutY = 340

      val separator1 = new Separator()
      separator1.layoutX = 300
      separator1.layoutY = 25
      separator1.prefHeight = 700
      //separator1.orientation

      //      var labelCustomerID = new Label("Customer ID")
      //      labelCustomerID.layoutX = 325
      //      labelCustomerID

      var labelUpdateItems = new Label("Update")
      labelUpdateItems.layoutY = 400
      labelUpdateItems.layoutX = 25

      var labelUpdateItemsID = new Label("Item ID")
      labelUpdateItemsID.layoutY = 430
      labelUpdateItemsID.layoutX = 25

      var TextfieldUpdateIDItem = new TextField
      TextfieldUpdateIDItem.layoutX = 25
      TextfieldUpdateIDItem.layoutY = 445

      val buttonItemDelete = new Button("Delete")
      buttonItemDelete.layoutX = 25
      buttonItemDelete.layoutY = 480

      val buttonItemRead = new Button("Read")
      buttonItemRead.layoutX = 100
      buttonItemRead.layoutY = 480

      val buttonItemAdd = new Button("Add")
      buttonItemAdd.layoutX = 175
      buttonItemAdd.layoutY = 480

      var labelAddNew = new Label("Add New")
      labelAddNew.layoutX = 25
      labelAddNew.layoutY = 525

      var labelItemType = new Label("Item ID")
      labelItemType.layoutY = 540
      labelItemType.layoutX = 25

      var TextfieldItemType = new TextField
      TextfieldItemType.layoutX = 25
      TextfieldItemType.layoutY = 555

      var labelItemName = new Label("Item ID")
      labelItemName.layoutY = 590
      labelItemName.layoutX = 25

      var TextfieldItemName = new TextField
      TextfieldItemName.layoutX = 25
      TextfieldItemName.layoutY = 605

      var labelItemPrice = new Label("Item ID")
      labelItemPrice.layoutY = 640
      labelItemPrice.layoutX = 25

      var TextfieldItemPrice = new TextField
      TextfieldItemPrice.layoutX = 25
      TextfieldItemPrice.layoutY = 655

      var labelItemPoints = new Label("Item ID")
      labelItemPoints.layoutY = 690
      labelItemPoints.layoutX = 25

      var TextfieldItemPoints = new TextField
      TextfieldItemPoints.layoutX = 25
      TextfieldItemPoints.layoutY = 705
      TextfieldItemPoints.prefWidth = 50

      val buttonItemAdd2 = new Button("Add")
      buttonItemAdd2.layoutX = 100
      buttonItemAdd2.layoutY = 705

      //      val buttonItemAdd22 = new Button("Add")
      //      buttonItemAdd2.layoutX = 925
      //      buttonItemAdd2.layoutY = 400

      //-------------------------------------------------
      //
      val buttonManager1 = new Button("Button1")
      buttonManager1.layoutX = 925
      buttonManager1.layoutY = 300

      val buttonManager2 = new Button("Button2")
      buttonManager2.layoutX = 1000
      buttonManager2.layoutY = 300

      val buttonManager3 = new Button("Button3")
      buttonManager3.layoutX = 1075
      buttonManager3.layoutY = 300

      val buttonManager4 = new Button("Button4")
      buttonManager4.layoutX = 925
      buttonManager4.layoutY = 340

      val buttonManager5 = new Button("Button5")
      buttonManager5.layoutX = 1000
      buttonManager5.layoutY = 340

      val buttonManager6 = new Button("Button6")
      buttonManager6.layoutX = 1075
      buttonManager6.layoutY = 340
      //
      //      val separator1 = new Separator()
      //      separator1.layoutX = 300
      //      separator1.layoutY = 25
      //      separator1.prefHeight = 700
      //      //separator1.orientation
      //
      //      //      var labelCustomerID = new Label("Customer ID")
      //      //      labelCustomerID.layoutX = 325
      //      //      labelCustomerID
      //
      var labelUpdateEmployee = new Label("Update")
      labelUpdateEmployee.layoutY = 400
      labelUpdateEmployee.layoutX = 925

      var labelUpdateEmployeeID = new Label("Item ID")
      labelUpdateEmployeeID.layoutY = 430
      labelUpdateEmployeeID.layoutX = 925

      var TextfieldUpdateIDEmployee = new TextField
      TextfieldUpdateIDEmployee.layoutX = 925
      TextfieldUpdateIDEmployee.layoutY = 445

      val buttonEmployeeDelete = new Button("Delete")
      buttonEmployeeDelete.layoutX = 925
      buttonEmployeeDelete.layoutY = 480

      val buttonEmployeeRead = new Button("Read")
      buttonEmployeeRead.layoutX = 1000
      buttonEmployeeRead.layoutY = 480

      val buttonEmployeeAdd = new Button("Add")
      buttonEmployeeAdd.layoutX = 1075
      buttonEmployeeAdd.layoutY = 480

      var labelAddNewEmployee = new Label("Add New")
      labelAddNewEmployee.layoutX = 925
      labelAddNewEmployee.layoutY = 525

      var labelEmployeeType = new Label("Item ID")
      labelEmployeeType.layoutY = 540
      labelEmployeeType.layoutX = 925

      var TextfieldEmployeeType = new TextField
      TextfieldEmployeeType.layoutX = 925
      TextfieldEmployeeType.layoutY = 555

      var labelEmployeeName = new Label("Item ID")
      labelEmployeeName.layoutY = 590
      labelEmployeeName.layoutX = 925

      var TextfieldEmployeeName = new TextField
      TextfieldEmployeeName.layoutX = 925
      TextfieldEmployeeName.layoutY = 605

      var labelEmployeePrice = new Label("Item ID")
      labelEmployeePrice.layoutY = 640
      labelEmployeePrice.layoutX = 925

      var TextfieldEmployeePrice = new TextField
      TextfieldEmployeePrice.layoutX = 925
      TextfieldEmployeePrice.layoutY = 655


      val buttonEmployeeAdd2 = new Button("Add")
      buttonEmployeeAdd2.layoutX = 925
      buttonEmployeeAdd2.layoutY = 705

      //-----------------------------------------------


      var listView2 = new ListView(List("Test 1", "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView2.layoutX = 325
      listView2.layoutY = 25
      listView2.prefHeight = 250
      listView2.prefWidth = 275

      var listView3 = new ListView(List("Test 1", "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView3.layoutX = 625
      listView3.layoutY = 25
      listView3.prefHeight = 250
      listView3.prefWidth = 275

      var listView4 = new ListView(List("Test 1", "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView4.layoutX = 925
      listView4.layoutY = 25
      listView4.prefHeight = 250
      listView4.prefWidth = 275

      var listView5 = new ListView(List("Test 1", "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView5.layoutX = 1225
      listView5.layoutY = 25
      listView5.prefHeight = 250
      listView5.prefWidth = 275

      var listView3res = new ListView(List("Test 1", "Test2", "Test3", "Test4", "Test5"))
      //var listView = new ListView(ObservableBuffer("Test 1","Test2","Test3","Test4","Test5"))
      listView3res.layoutX = 625
      listView3res.layoutY = 300
      listView3res.prefHeight = 250
      listView3res.prefWidth = 275

      var labelres = new Label("Predicted amount: " )
      labelres.layoutY = 560
      labelres.layoutX = 625

      content = List(listView, listView2, listView3, listView4, listView5, separator1, rb2, rb1, button1, button2
        , button3, button4, button5, button6, labelUpdateItems, labelUpdateItemsID, TextfieldUpdateIDItem, buttonItemAdd,
        buttonItemDelete, buttonItemRead, labelAddNew, labelItemType, TextfieldItemType, TextfieldItemName, labelItemName,
        labelItemPrice, TextfieldItemPrice, labelItemPoints, TextfieldItemPoints, buttonItemAdd2, buttonManager1,
        buttonManager2, buttonManager3, buttonManager4, buttonManager5, buttonManager6, labelUpdateEmployee, labelUpdateEmployeeID,
        TextfieldUpdateIDEmployee, buttonEmployeeDelete, buttonEmployeeAdd, buttonEmployeeRead, labelAddNewEmployee,
        labelEmployeeType, labelEmployeeName, TextfieldEmployeeName, TextfieldEmployeeType, labelEmployeePrice, TextfieldEmployeePrice,
        buttonEmployeeAdd2, listView3res, labelres)


    }
  }

}
