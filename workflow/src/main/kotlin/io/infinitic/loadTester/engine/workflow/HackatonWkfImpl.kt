package io.infinitic.loadTester.engine.workflow

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.loadTester.engine.supplier.SupplierAAA
import io.infinitic.loadTester.engine.supplier.SupplierBBB
import io.infinitic.workflows.*

class HackatonWkfImpl : Workflow(), HackatonWkf {
  override val channel: Channel<String> = channel<String>()
  private val supplierAAAService = newTask<SupplierAAA>()
  private val supplierBBBService = newTask<SupplierBBB>()

  override fun handle(data: String) {
    inline { PrometheusRegistry.registry.counter("workflow_start").increment() }

    val resultSupplierAAA: Deferred<Boolean> = async { supplierAAAService.checkStock(data) }
    val resultSupplierBBB: Deferred<Boolean> = async { supplierBBBService.checkStock(data) }
    val result =
        when ((resultSupplierBBB or resultSupplierAAA).await()) {
          // If the first supplier to reply doesn't have stock wait for the other (passage to or)
          false -> (resultSupplierBBB and resultSupplierAAA).await().any { it }
          true -> true
        }
    when (result) {
      true -> // one of the supplier as stock, order from it
          when {
            resultSupplierBBB.isCompleted() && resultSupplierBBB.await() ->
                supplierBBBService.orderProduct(data)
            resultSupplierAAA.isCompleted() && resultSupplierAAA.await() ->
                supplierAAAService.orderProduct(data)
          }
      false -> inline { PrometheusRegistry.registry.counter("no_supplier").increment() }
    }
    inline { PrometheusRegistry.registry.counter("workflow_end").increment() }
  }
}
