plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "com.github.rileymichael"

application {
    mainClass.set("${group}.AdventKt")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.time.ExperimentalTime"
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
}