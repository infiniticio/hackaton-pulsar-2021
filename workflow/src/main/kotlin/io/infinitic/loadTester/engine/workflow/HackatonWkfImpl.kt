package io.infinitic.loadTester.engine.workflow

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.loadTester.engine.supplier.SupplierAAA
import io.infinitic.loadTester.engine.supplier.SupplierBBB
import io.infinitic.workflows.Channel
import io.infinitic.workflows.Deferred
import io.infinitic.workflows.Workflow
import io.infinitic.workflows.or

class HackatonWkfImpl : Workflow(), HackatonWkf {
  override val channel: Channel<String> = channel<String>()
  private val supplierAAAService = newTask<SupplierAAA>()
  private val supplierBBBService = newTask<SupplierBBB>()

  override fun handle(data: String) {
    inline { PrometheusRegistry.registry.counter("workflow_start").increment() }

    val resultSupplierAAA: Deferred<Boolean> = async {
      supplierAAAService.reserveStock(data).also { supplierAAAService.getProduct(data) }
    }
    val resultSupplierBBB: Deferred<Boolean> = async {
      supplierBBBService.reserveStock(data).also { supplierBBBService.getProduct(data) }
    }
    (resultSupplierBBB or resultSupplierAAA).await()
    when {
      resultSupplierBBB.isCompleted() && resultSupplierBBB.await() ->
          supplierAAAService.cancelStock(data)
      resultSupplierAAA.isCompleted() && resultSupplierAAA.await() ->
          supplierBBBService.cancelStock(data)
      else -> inline { PrometheusRegistry.registry.counter("no_supplier").increment() }
    }
    inline { PrometheusRegistry.registry.counter("workflow_end").increment() }
  }
}
