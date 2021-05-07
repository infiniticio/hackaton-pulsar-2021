package io.infinitic.loadTester.engine.supplier

//interface SupplierBBB : SupplierInterface

interface SupplierBBB {
    fun checkStock(product: String):Boolean
    fun orderProduct(product: String)
}