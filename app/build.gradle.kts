import io.infinitic.loadTester.Libs
plugins { id("io.infinitic.loadTester.kotlin-application-conventions") }

dependencies {
  // webserver HTTP4K
  implementation(Libs.Http4k.core)
  implementation(Libs.Http4k.jettyServer)
  implementation(Libs.Http4k.micrometer)
  implementation(Libs.MicroMeter.prometheus)
  // cliarg parser
  implementation(Libs.ArgParser.core)
  // Logging
  implementation(Libs.Slf4j.api) { version { strictly("1.7.30") } }
  implementation(Libs.Logback.classic)
  implementation(project(":launcher"))
  implementation(project(":workflow"))
  implementation(project(":config"))
}

application {
  // Define the main class for the application.
  mainClass.set("io.infinitic.loadTester.app.AppKt")
}
