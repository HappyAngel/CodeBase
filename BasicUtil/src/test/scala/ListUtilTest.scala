import happyangel.codebase.basicutil.ListUtil
import org.scalatest.{FlatSpec, Matchers}

import scala.util.Try

class ListUtilTest extends FlatSpec with Matchers {
  "map2" should "correctly behave input all have value" in {
    val i1 = Some(1)
    val i2 = Some(2)
    val res = ListUtil.map2(i1, i2)(_+_)
    res shouldBe Some(3)
  }

  "map2" should "correctly behave input has none value" in {
    val i1 = Some(1)
    val i2 = None
    val res = ListUtil.map2[Int, Int, Int](i1, i2)(_+_)
    res shouldBe None
  }

  "traverse" should "correctly behave all inputs have value" in {
    val ll = List("1","2","3","4","5")
    val res = ListUtil.traverse(ll) { v =>
      Try(v.toInt).toOption
    }
    res.get.size shouldBe 5
  }

  "traverse" should "correctly behave when one of the input is None" in {
    val ll = List("1","2","adsfas","4","5")
    val res = ListUtil.traverse(ll) { v =>
      Try(v.toInt).toOption
    }
    res shouldBe None
  }

  "sequence" should "correctly behave when one of the input is None" in {
    val ll = List(Some(1), None, Some(11), Some(4), Some(5))
    val res = ListUtil.sequenceRur(ll)
    res shouldBe None
  }

  "sequence" should "correctly behave when all inputs have value" in {
    val ll = List(Some(1), Some(11), Some(4), Some(5))
    val res = ListUtil.sequenceRur(ll)
    res.get.size shouldBe 4
  }
}