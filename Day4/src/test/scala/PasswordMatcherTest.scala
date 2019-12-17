import org.scalatest.FunSuite

class PasswordMatcherTest extends FunSuite {
  val correctSeq: List[Int] = List(3, 3, 4, 5, 6, 7);
  val longSeq: List[Int] = List(0, 0, 0, 0, 0, 0, 0);
  val noDoubles: List[Int] = List(1, 2, 3, 4, 5, 6);
  val decreasingSeq: List[Int] = List(5, 4, 6, 7, 8, 8);

  test("A sequence greater than 6 digits fails") {
    assert(!PasswordMatcher.isMatch(longSeq));
  }

  test("A valid sequence of exactly 6 digits passes") {
    assert(PasswordMatcher.isMatch(correctSeq));
  }

  test("A sequence with no doubles fails") {
    assert(!PasswordMatcher.isMatch(noDoubles));
  }

  test("A sequence with decreasing digits fails") {
    assert(!PasswordMatcher.isMatch((decreasingSeq)))
  }

  test("A check of valid passwords between 122456 and 122457 returns 2") {
    assert(PasswordMatcher.countMatches(122455, 122457, 0) == 2);
  }
}
