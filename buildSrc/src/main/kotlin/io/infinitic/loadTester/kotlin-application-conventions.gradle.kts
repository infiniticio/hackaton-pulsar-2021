package io.infinitic.loadTester

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("io.infinitic.loadTester.kotlin-common-conventions")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}