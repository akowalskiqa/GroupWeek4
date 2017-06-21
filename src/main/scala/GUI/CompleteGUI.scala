//package GUI
//
//import scalafx.Includes._
//import scalafx.application.JFXApp
//import scalafx.application.JFXApp.PrimaryStage
//import scalafx.geometry.Insets
//import scalafx.scene.Scene
//import scalafx.scene.control.{Button, Label, TextArea, TextField, PasswordField}
//import scalafx.scene.effect.DropShadow
//import scalafx.scene.layout.HBox
//import scalafx.scene.paint.Color._
//import scalafx.scene.paint.{LinearGradient, Stops}
//import scalafx.scene.text.Text
//import scalafx.event.ActionEvent
//
//
//object CompleteGUI extends JFXApp {
//
//  stage = new PrimaryStage {
//    title = "First GUI"
//    scene = new Scene(400, 400) {
//      val label = new Label("Employee ID")
//      label.layoutX = 20
//      label.layoutY = 30
//
//      val textfield = new TextField
//      textfield.layoutX = 20
//      textfield.layoutY = 50
//
//      val label2 = new Label("Employee Password")
//      label2.layoutX = 20
//      label2.layoutY = 100
//
//      val passwordfield = new PasswordField
//      passwordfield.layoutX = 20
//      passwordfield.layoutY = 120
//
//      val button = new Button("Login")
//      button.layoutX = 20
//      button.layoutY = 160
//
//      content = List(label, textfield, passwordfield, label2, button)
//
////      button.onAction = (e:ActionEvent) =>
//
//        //OnAction -- Button action goes in here
//
////        var str : String = textfield.text.toString()
////        var stranswer : String = "Emp1"
////
////
////
////        if(str.equals(stranswer)) {
////          println("Correct")
////          println("" + str)
////        }
////        else {
////          println("Incorrect")
////          println("" + textfield.text.toString())
////        }
//
//
//      }
//    }
//
//
//  }
