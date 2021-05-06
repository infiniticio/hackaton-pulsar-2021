package io.infinitic.loadTester.engine.supplier

interface SupplierInterface {
  fun reserveStock(product: String)
  fun getProduct(product: String)
  fun cancelStock(product: String)
}
