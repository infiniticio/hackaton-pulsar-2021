package io.infinitic.loadTester

/**
 * "Commons Clause" License Condition v1.0
 *
 * The Software is provided to you by the Licensor under the License, as defined
 * below, subject to the following condition.
 *
 * Without limiting other conditions in the License, the grant of rights under the
 * License will not include, and the License does not grant to you, the right to
 * Sell the Software.
 *
 * For purposes of the foregoing, “Sell” means practicing any or all of the rights
 * granted to you under the License to provide to third parties, for a fee or
 * other consideration (including without limitation fees for hosting or
 * consulting/ support services related to the Software), a product or service
 * whose value derives, entirely or substantially, from the functionality of the
 * Software. Any license notice or attribution required by the License must also
 * include this Commons Clause License Condition notice.
 *
 * Software: Infinitic
 *
 * License: MIT License (https://opensource.org/licenses/MIT)
 *
 * Licensor: infinitic.io
 */

object Libs {
    // Plugins version
    const val kotlinVersion = "1.4.31"

    const val org = "io.infinitic"

    object Kotlin {
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    }

    object Coroutines {
        private const val version = "1.4.3"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val jdk8 = "org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$version"
    }

    object MicroMeter {
        const val prometheus = "io.micrometer:micrometer-registry-prometheus:1.6.+"
    }

    object Infinitic {
        private const val version = "0.6.0"
        const val pulsar = "io.infinitic:infinitic-pulsar:0.6.0"
        const val client = "io.infinitic:infinitic-client:0.6.0"
        const val config = "io.infinitic:infinitic-config:0.6.0"
    }

    object ArgParser {
        const val core = "com.xenomachina:kotlin-argparser:2.0.+"
    }

    object Http4k {
        private const val version = "4.8.+"
        const val core = "org.http4k:http4k-core:$version"
        const val jettyServer = "org.http4k:http4k-server-jetty:$version"
        const val jettyClient = "org.http4k:http4k-client-jetty:$version"
        const val micrometer = "org.http4k:http4k-metrics-micrometer:$version"
    }

    object Slf4j {
        const val api = "org.slf4j:slf4j-api:1.7.+"
    }

    object Logback {
        const val classic = "ch.qos.logback:logback-classic:1.2.+"
    }

    object Hoplite {
        private const val version = "1.4.0"
        const val core = "com.sksamuel.hoplite:hoplite-core:$version"
        const val yaml = "com.sksamuel.hoplite:hoplite-yaml:$version"
    }
}
