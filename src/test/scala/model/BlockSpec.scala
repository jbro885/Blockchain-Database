package model

import org.scalatest._
import org.scalatest.matchers.should.Matchers

class BlockSpec extends WordSpec with Matchers {
  "A Block" when {
    "new" should {
      val block = new Block(0, "1575488199270", "test", "test", "test")
      "have a toString method" in {
        block.toString should be("Block(0,1575488199270,test,test)")
      }
    }
  }
}
