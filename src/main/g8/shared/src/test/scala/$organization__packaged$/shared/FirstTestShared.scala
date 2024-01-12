package org.aurora

import org.scalatest._
import wordspec._
import matchers._



class FirstTestShared extends AnyWordSpec with should.Matchers{
  "this" should {
    "work" in {
        true should be(true)
    }
  }
}
