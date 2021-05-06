package io.infinitic.loadTester.engine.supplier

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.tasks.Task
import org.slf4j.LoggerFactory

class SupplierAAAImpl : Task(), SupplierAAA {
  private val logger = LoggerFactory.getLogger(javaClass)

  override fun reserveStock(product: String) {
    PrometheusRegistry.registry.counter("supplierAAA_reserveStock").increment()
    logger.info("Supplier AAA - reserveStock ${context.workflowId}")
  }

  override fun getProduct(product: String) {
    PrometheusRegistry.registry.counter("supplierAAA_getProduct").increment()
    logger.info("Supplier AAA - getProduct ${context.workflowId}")
  }

  override fun cancelStock(product: String) {
    PrometheusRegistry.registry.counter("supplierAAA_cancelStock").increment()
    logger.info("Supplier AAA - cancelStock ${context.workflowId}")
  }
}
