package base

object ForOptional {
  def main(args: Array[String]): Unit = {

    val capitals = Map("France"->"Paris", "Japan"->"Tokyo", "China"->"Beijing")

    val res = capitals get "France"

    print(res)

  }
}
