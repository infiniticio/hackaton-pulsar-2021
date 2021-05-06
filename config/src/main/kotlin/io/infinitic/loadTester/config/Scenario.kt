package io.infinitic.loadTester.config

data class Scenario(
    val name: String,
    val launches: List<Launch>
) {
    private var _klass: Class<WorkflowInterface>? = null

    val klass: Class<WorkflowInterface>
        get() = (_klass ?: run {
            val k = Class.forName(name) as Class<WorkflowInterface>
            _klass = k
            k
        })

    init {
        require(try { klass; true } catch (e: ClassNotFoundException) { false }) {
            "class $name is unknown"
        }
        require(try { klass; true } catch (e: ClassCastException) { false }) {
            "class $name must implement ${WorkflowInterface::class}"
        }
    }
}