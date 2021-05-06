package io.infinitic.loadTester.engine.workflow

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.loadTester.engine.supplier.SupplierAAA
import io.infinitic.loadTester.engine.supplier.SupplierBBB
import io.infinitic.workflows.Channel
import io.infinitic.workflows.Workflow
import io.infinitic.workflows.or

class HackatonWkfImpl : Workflow(), HackatonWkf {
  override val channel: Channel<String> = channel<String>()
  private val supplierAAAService = newTask<SupplierAAA>()
  private val supplierBBBService = newTask<SupplierBBB>()

  override fun reserveFromFastestSupplier(product: String) {
    inline { PrometheusRegistry.registry.counter("workflow_start").increment() }
    val supplierAAA = async {
      supplierAAAService.reserveStock(product)
      supplierAAAService.getProduct(product)
    }
    val supplierBBB = async {
      supplierBBBService.reserveStock(product)
      supplierBBBService.getProduct(product)
    }
    (supplierAAA or supplierBBB).await()
    when {
      supplierAAA.isCompleted() -> supplierBBBService.cancelStock(product)
      supplierBBB.isCompleted() -> supplierAAAService.cancelStock(product)
    }
    inline { PrometheusRegistry.registry.counter("workflow_end").increment() }
  }
}
