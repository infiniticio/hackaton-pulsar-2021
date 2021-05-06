package io.infinitic.loadTester.engine.workflow

import io.infinitic.loadTester.config.WorkflowInterface
import io.infinitic.workflows.Channel

interface HackatonWkf: WorkflowInterface {
  val channel: Channel<String>

  override fun handle(data: String)
}
