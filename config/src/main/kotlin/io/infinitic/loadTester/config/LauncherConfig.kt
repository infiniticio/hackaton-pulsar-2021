package io.infinitic.loadTester.config

import io.infinitic.config.loaders.loadConfigFromFile

data class LauncherConfig(
    val workflow: Workflow,
    val launches: List<Launch>
) {
    companion object {
        fun fromConfigFile(vararg files: String): LauncherConfig =
            loadConfigFromFile(files.toList())
    }
}