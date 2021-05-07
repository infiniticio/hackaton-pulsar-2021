package io.infinitic.loadTester.engine.supplier

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.tasks.Task
import kotlin.random.Random
import org.slf4j.LoggerFactory

class SupplierAAAImpl : Task(), SupplierAAA {
  private val logger = LoggerFactory.getLogger(javaClass)

  override fun checkStock(product: String): Boolean {
    Thread.sleep(Random.nextLong(1000))
    PrometheusRegistry.registry.counter("supplierAAA_reserveStock").increment()
    logger.info("Supplier AAA - reserveStock ${context.workflowId}")
    return Random.nextBoolean()
  }

  override fun orderProduct(product: String) {
    PrometheusRegistry.registry.counter("supplierAAA_getProduct").increment()
    logger.info("Supplier AAA - getProduct ${context.workflowId}")
  }
}
