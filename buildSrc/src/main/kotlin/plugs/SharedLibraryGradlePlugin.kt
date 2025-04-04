package plugs

import build.BuildConfig
import build.BuildDimensions
import com.android.build.gradle.LibraryExtension
import flavors.BuildFlavor
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import test.TestBuildConfig

class SharedLibraryGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println(project.project)
        println("SharedClass : 1")
        project.addPluginConfigurations()
        println("SharedClass : 2")
        project.addAndroidConfigurations()
        println("SharedClass : 3")
        project.applyKotlinOptions()
        println("SharedClass : 4")
    }

    private fun Project.addPluginConfigurations() {
        plugins.apply(BuildPlugins.KOTLIN_ANDROID)
        plugins.apply(BuildPlugins.KAPT)
    }

    private fun Project.addAndroidConfigurations() {
        extensions.getByType(LibraryExtension::class.java).apply {
            compileSdk = BuildConfig.COMPILE_SDK_VERSION

            defaultConfig {
                minSdk = BuildConfig.MIN_SDK_VERSION
                testInstrumentationRunner = TestBuildConfig.TEST_INSTRUMENTATION_RUNNER
            }
            flavorDimensions.add(BuildDimensions.APP)
            flavorDimensions.add(BuildDimensions.STORE)

            productFlavors {
                BuildFlavor.Google.createLibrary(this)
                BuildFlavor.Huawei.createLibrary(this)
                BuildFlavor.Client.createLibrary(this)
                BuildFlavor.Driver.createLibrary(this)
            }

            buildFeatures {
//                compose = true
//                buildConfig = true
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }
    }

    private fun Project.applyKotlinOptions() {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
            }
        }
    }
}