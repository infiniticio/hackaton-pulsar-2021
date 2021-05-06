import io.infinitic.loadTester.Libs

plugins { id("io.infinitic.loadTester.kotlin-library-conventions") }

dependencies {
  // prometheus
  implementation(Libs.MicroMeter.prometheus)
}
