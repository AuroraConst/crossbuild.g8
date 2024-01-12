package org.aurora

import org.scalatest._
import wordspec._
import matchers._



class FirstTestJvm extends AnyWordSpec with should.Matchers{
  "this" should {
    "work" in {
      import org.aurora.shared.StubSharedDTO
      val s = new StubSharedDTO() // this should compile from shared code
      true should be(true)
    }
  }
}
