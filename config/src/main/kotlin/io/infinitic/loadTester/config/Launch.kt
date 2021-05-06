package io.infinitic.loadTester.config

import java.time.Duration

data class Launch(
    val duration: Duration,
    val number: Int,
    val shape: Shape,
)