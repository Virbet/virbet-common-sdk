import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.20"

    id("maven-publish")

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

group = "com.github.Virbet"


repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}


dependencies {
    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("io.ktor:ktor-client-core:2.3.6")
    api("com.squareup.retrofit2:converter-gson:2.5.0")
    api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    api("com.aventrix.jnanoid:jnanoid:2.0.0")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.auth0:java-jwt:4.4.0")
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}


//
publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}





// Apply a specific Java toolchain to ease working on different environments.
java {
    withSourcesJar()
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "11"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "11"
}
