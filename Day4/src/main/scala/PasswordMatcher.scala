object PasswordMatcher {

  def countMatches(start: Int, end: Int, counter: Int): Int = {
    if (start <= end) {
      var total = counter;
      if(isMatch(start.toString.map(_.asDigit).toList.asInstanceOf[List[Int]])) total += 1
      countMatches(start + 1, end, total)
    }

    counter
  }


  def isMatch(sequence: List[Int]):Boolean = {
    def hasDouble(sequence: List[Int]): Boolean = {
      sequence match {
        case x :: y :: _ if y >= x =>
          if (x == y) true else hasDouble(sequence.tail)
        case _ =>
          false
      }
    }

    def decreases(sequence: List[Int]): Boolean = {
      sequence match {
        case x :: y :: _  =>
          if (y < x) true else decreases(sequence.tail)
        case _ =>
          false
      }
    }

    sequence match {
      case _ :: _ :: _ :: _ :: _ :: _ :: Nil =>
        hasDouble(sequence) && !decreases(sequence)
      case _ =>
        false
    }
  }





}
