plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    api(kotlin("gradle-plugin:2.0.0"))
    implementation("com.android.tools.build:gradle:8.8.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
}