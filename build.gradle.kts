import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    application
}

buildscript {
    dependencies {
        classpath("io.realm.kotlin:gradle-plugin:1.0.1")
    }
}
rootProject.extra["realmVersion"] = "1.0.0"

apply(plugin = "io.realm.kotlin")

group = "io.realm.example"
version = "1.0.0"

repositories {
    mavenCentral()
    // Only required for realm-kotlin snapshots
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}
dependencies {
    implementation("io.realm.kotlin:library-base:1.0.1")
    testImplementation(kotlin("test-junit"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
application {
    mainClassName = "io.realm.example.Main"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "io.realm.example.Main"
    }
    configurations["runtimeClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
