package io.infinitic.loadTester.engine.supplier

//interface SupplierAAA : SupplierInterface

interface SupplierAAA {
    fun reserveStock(product: String)
    fun getProduct(product: String)
    fun cancelStock(product: String)
}