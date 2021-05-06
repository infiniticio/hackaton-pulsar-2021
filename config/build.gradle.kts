
import io.infinitic.loadTester.Libs

plugins {
    id("io.infinitic.loadTester.kotlin-library-conventions")
}

dependencies {
    implementation(Libs.Hoplite.core)
    implementation(Libs.Hoplite.yaml)
    implementation(Libs.Infinitic.config)
}
