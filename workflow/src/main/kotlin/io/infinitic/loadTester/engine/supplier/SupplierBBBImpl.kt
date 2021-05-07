package io.infinitic.loadTester.engine.supplier

import io.infinitic.loadTester.engine.PrometheusRegistry
import io.infinitic.tasks.Task
import org.slf4j.LoggerFactory
import kotlin.random.Random

class SupplierBBBImpl : Task(), SupplierBBB {
  private val logger = LoggerFactory.getLogger(javaClass)
  override fun reserveStock(product: String):Boolean {
    Thread.sleep(Random.nextLong(10))
    PrometheusRegistry.registry.counter("supplierBBB_reserveStock").increment()
    logger.info("Supplier BBB - reserveStock ${context.workflowId}")
    return Random.nextBoolean()
  }

  override fun getProduct(product: String) {
    PrometheusRegistry.registry.counter("supplierBBB_getProduct").increment()
    logger.info("Supplier BBB - getProduct ${context.workflowId}")
  }

  override fun cancelStock(product: String) {
    PrometheusRegistry.registry.counter("supplierBBB_cancelStock").increment()
    logger.info("Supplier BBB - cancelStock ${context.workflowId}")
  }
}
