package io.infinitic.loadTester.engine.supplier

//interface SupplierAAA : SupplierInterface

interface SupplierAAA {
    fun checkStock(product: String):Boolean
    fun orderProduct(product: String)
}