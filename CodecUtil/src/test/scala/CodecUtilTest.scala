import happyangel.codebase.codecutil.Algorithm
import main.scala.happyangel.codebase.codecutil.Base64Util
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by xionglei on 17-12-29.
  */

class CodecUtilTest extends FlatSpec with Matchers {
    "Base64 util" should "generate right md5 string" in {
        val originStr = "hello world"
        val res = Base64Util.getBase64Encode(originStr)(Algorithm.MD5)
        println(res)
        res shouldBe "XrY7u+Ae7tCTyyK7j1rNww=="
    }
}
