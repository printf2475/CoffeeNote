import com.edc.convention.configureCoroutineAndroid
import com.edc.convention.configureDataAndroid
import com.edc.convention.configureKotlinAndroid
import com.edc.convention.libs

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureDataAndroid()

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    val libs = project.extensions.libs
    implementation(libs.findLibrary("junit4").get())
    implementation(libs.findLibrary("androidx.runner").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
}