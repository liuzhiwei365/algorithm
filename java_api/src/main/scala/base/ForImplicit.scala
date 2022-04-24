package base

object ForImplicit {

  class SpecialPerson(val name: String)
  class Student(val name: String)
  class Older(val name: String)

  implicit def object2SpecialPerson (obj: Object): SpecialPerson = {
    if (obj.getClass == classOf[Student]) { val stu = obj.asInstanceOf[Student]; new SpecialPerson(stu.name) }
    else if (obj.getClass == classOf[Older]) { val older = obj.asInstanceOf[Older]; new SpecialPerson(older.name) }
    else null
  }

  var ticketNumber = 0
  def buySpecialTicket(p: SpecialPerson) = {
    ticketNumber += 1
    "T-" + ticketNumber
  }


  class Man(val name: String)
  class Superman(val name: String) {
    def emitLaser = println("emit a laster!")
  }

  implicit def man2superman(man: Man): Superman = new Superman(man.name)



  class Woman(val name:String)

  object Woman{
    implicit def man2super(woman: Woman): Superman = new Superman(woman.name)
  }


  class Superwoman(val name: String) {
    def emitLaser = println("emit a laster!")
  }
  /**
   scala默认会使用两种隐式转换,

   一种是源类型,或者目标类型的伴生对象内的隐式转换函数;
   一种是当前程序作用域内的可以用唯一标识符表示的隐式转换函数

   如果隐式转换函数不在上述两种情况下的话，那么就必须手动使用import语法引入某个包下的隐式转换函数,
   比如import test._。通常建议，仅仅在需要进行隐式转换的地方，比如某个函数或者方法内,
   用import导入隐式转换函数，这样可以缩小隐式转换函数的作用域，避免不需要的隐式转换。
   */
  def main(args: Array[String]): Unit = {
    //  本来该函数只能传入SpecialPerson 类型,但是我们这里传入Student类型 依然没有问题。
    //  scala编译器在底层会自动调用隐式转换函数， 将我们的Student对象 转换为SpecialPerson 对象。
    buySpecialTicket(new Student("123"))

    print(ticketNumber)

    print("\n\r")
    //  可以调用一个类原本没有的方法, Man类型隐式转换成SuperMan类型, SuperMan类型有这个方法
    val leo = new Man("leo")
    leo.emitLaser

    val lex = new Woman("lex")
    leo.emitLaser

  }


  //隐式参数
  class SignPen {
    def write(content: String) = println(content)
  }
  implicit val signPen = new SignPen

  def signForExam(name: String) (implicit signPen: SignPen) {
    signPen.write(name + " come to exam in time.")
  }


}

