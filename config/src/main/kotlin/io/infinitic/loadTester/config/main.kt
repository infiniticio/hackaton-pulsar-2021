package io.infinitic.loadTester.config

fun main() {
    val config = LauncherConfig.fromConfigFile("scenario.yml")

    println(config)
}