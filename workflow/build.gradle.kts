import io.infinitic.loadTester.Libs

plugins { id("io.infinitic.loadTester.kotlin-library-conventions") }

dependencies {
  // prometheus
  implementation(Libs.MicroMeter.prometheus)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }
}

tasks.withType<JavaCompile> {
  sourceCompatibility = JavaVersion.VERSION_1_8.toString()
  targetCompatibility = JavaVersion.VERSION_1_8.toString()
}
