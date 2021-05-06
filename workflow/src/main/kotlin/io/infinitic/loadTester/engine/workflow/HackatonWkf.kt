package io.infinitic.loadTester.engine.workflow

import io.infinitic.workflows.Channel

interface HackatonWkf {
  val channel: Channel<String>

  fun reserveFromFastestSupplier(product: String)
}
