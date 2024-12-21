import com.edc.convention.configureCoilAndroid
import com.edc.convention.configureHiltAndroid
import com.edc.convention.libs
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("edc.android.library")
    id("edc.android.compose")
    id("kotlin-parcelize")
}

android {
    packaging {
        resources {
            excludes.add("META-INF/**")
        }
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()
configureCoilAndroid()

dependencies {
    val libs = project.extensions.libs
    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:localize"))
    implementation(project(":core:util"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))


    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("kotlinx.serialization.json").get())
    implementation(libs.findLibrary("orbit.compose").get())
    implementation(libs.findLibrary("orbit.core").get())
    implementation(libs.findLibrary("orbit.viewmodel").get())
}