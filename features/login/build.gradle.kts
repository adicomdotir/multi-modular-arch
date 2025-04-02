import deps.androidx
import deps.hilt
import deps.room
import deps.testDebugDeps
import deps.testDeps
import deps.testImplDeps
import plugs.SharedLibraryGradlePlugin

plugins {
    println("login : 1")
    id(plugs.BuildPlugins.ANDROID_LIBRARY)
    println("login : 2")
}

apply<SharedLibraryGradlePlugin>()

android {
    println("login : 3")
    namespace = "ir.adicom.login"
    println("login : 4")
}

dependencies {
    println("login : 5")
    androidx()
    hilt()
    room()
    testDeps()
    testImplDeps()
    testDebugDeps()
    println("login : 6")
}