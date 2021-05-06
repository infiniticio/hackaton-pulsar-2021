
package io.infinitic.loadTester.engine

import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry

/** Prometheus registry singleton */
object PrometheusRegistry {
  val registry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
}
