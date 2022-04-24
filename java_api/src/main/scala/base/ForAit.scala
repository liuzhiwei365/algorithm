package base



//@是为了给模式匹配起个变量名，一般格式为：variableName@pattern，示例：
object ForAit {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, 5, 6)

    list match {
      //right其实就代表了一个集合，元素为3，4，5，6
      case List(_, _, right@_*) => println(right)
      case _ =>
    }

    list match {
      //这种写法错误
      //case l:List(_, _, _*) => println(right)

      //正确写法，下面两种输出  元素  1, 2, 3, 4, 5, 6
      case list@List(_, _, _*) => println(list)
      case list: List[_] => println(list)
    }


    var set = Set("1","2","3","4")

    //("lzw","lqq")::
    val a = set.foldLeft(List[(String,String)]()){
          //res  的类型为 List[(String,String)]
      (res ,b) =>
        (b,"xxx") :: res
    }

    print(a)

  }

}
