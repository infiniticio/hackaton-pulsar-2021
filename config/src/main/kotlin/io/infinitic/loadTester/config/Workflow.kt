package io.infinitic.loadTester.config

import kotlin.reflect.KClass

data class Workflow(
    val name: String
) {
    private var _klass: Class<*>? = null

    val klass: Class<*>
        get() = _klass ?: run {
            val k = Class.forName(name)
            _klass = k
            k
        }

    init {
        require(try { klass; true } catch (e: ClassNotFoundException) { false }) {
            "class $name is unknown"
        }
    }
}