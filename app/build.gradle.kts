import io.infinitic.loadTester.Libs
plugins { id("io.infinitic.loadTester.kotlin-application-conventions") }

dependencies {
  // webserver HTTP4K
  implementation(io.infinitic.loadTester.Libs.Http4k.core)
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
