package io.infinitic.loadTester.engine.supplier

//interface SupplierBBB : SupplierInterface

interface SupplierBBB {
    fun reserveStock(product: String)
    fun getProduct(product: String)
    fun cancelStock(product: String)
}