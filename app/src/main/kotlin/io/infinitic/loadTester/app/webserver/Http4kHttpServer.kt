package io.infinitic.loadTester.app.webserver

import io.infinitic.loadTester.engine.PrometheusRegistry
import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.MicrometerMetrics
import org.http4k.filter.ServerFilters
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Jetty
import org.http4k.server.asServer

class Http4kHttpServer(port: Int) {

  private val app =
      routes(
          "/health-check" bind Method.GET to { Response(OK).body("""{"health":true}""") },
          "/ready" bind Method.GET to { Response(OK).body("""{"ready":true}""") },
          "/metrics" bind Method.GET to { Response(OK).body(PrometheusRegistry.registry.scrape()) },
      )

  private var server =
      ServerFilters.MicrometerMetrics.RequestCounter(PrometheusRegistry.registry)
          .then(ServerFilters.MicrometerMetrics.RequestTimer(PrometheusRegistry.registry))
          .then(app)
          .asServer(Jetty(port))

  init {
    Runtime.getRuntime().addShutdownHook(Thread { server.stop() })
  }

  fun startServer() {
    server.start()
  }

  fun startAndBlockServer() {
    server.start().block()
  }
}
