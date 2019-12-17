object Program {
  def run(program: List[Int]) = {
    findMatch(program, 19690720)
  }

  private def execute(program: List[Int], acc: List[Int]): List[Int] = {
    program match {
      case 1 :: input1 :: input2 :: position :: _ =>
        val result = acc(input1) + acc(input2)
        execute(program.drop(4), acc.take(position) ::: List(result) ::: acc.drop(position + 1))
      case 2 :: input1 :: input2 :: position :: _ =>
        val result = acc(input1) * acc(input2)
        execute(program.drop(4), acc.take(position) ::: List(result) ::: acc.drop(position + 1))
      case 99 :: _ => acc
    }
  }

  private def findMatch(program: List[Int], value: Int): (Int, Int) = {
    for(x <- 0 to 99 ) {
      for(y <- 0 to 99) {
          val alteredList = program.take(1) ::: List(x, y) ::: program.drop(3);
          val result = execute(alteredList, alteredList);
        if(result(0) == value) {
          return (x,y);
        }

      }
    }

    (0, 0)
  }
}
