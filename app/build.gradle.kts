/*
 * This file was generated by the Gradle 'init' task.
 */

plugins { id("io.infinitic.loadTester.kotlin-application-conventions") }

object Libs {
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
}

dependencies {
  // webserver HTTP4K
  implementation(Libs.Http4k.core)
  implementation(Libs.Http4k.jettyServer)
  implementation(Libs.Http4k.micrometer)
  implementation(
      Io_infinitic_loadTester_kotlin_common_conventions_gradle.Libs.MicroMeter.prometheus)
  // cliarg parser
  implementation(Libs.ArgParser.core)
  // Logging
  implementation(Libs.Slf4j.api) { version { strictly("1.7.30") } }
  implementation(Libs.Logback.classic)
  implementation(project(":launcher"))
  implementation(project(":workflow"))
}

application {
  // Define the main class for the application.
  mainClass.set("io.infinitic.loadTester.app.AppKt")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }
}

tasks.withType<JavaCompile> {
  sourceCompatibility = JavaVersion.VERSION_1_8.toString()
  targetCompatibility = JavaVersion.VERSION_1_8.toString()
}
