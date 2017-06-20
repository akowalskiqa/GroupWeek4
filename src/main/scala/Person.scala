/**
  * Created by Administrator on 19/06/2017.
  */
abstract class Person(var name:String) {
  def getName():String={name}
  def setName(newName:String):Unit={name=newName}
}
