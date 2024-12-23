
import com.edc.convention.configureCoilAndroid
import com.edc.convention.configureFirebaseAndroid
import com.edc.convention.configureHiltAndroid
import com.edc.convention.configureKotlinAndroid
import com.edc.convention.libs
import org.gradle.kotlin.dsl.dependencies
import gradle.kotlin.dsl.accessors._4b055a01bae563bd2c86a468691a3401.androidTestImplementation
import gradle.kotlin.dsl.accessors._4b055a01bae563bd2c86a468691a3401.implementation

plugins {
    id("com.android.application")
    id("edc.android.compose")
}

configureKotlinAndroid()
configureHiltAndroid()
configureCoilAndroid()
//configureFirebaseAndroid()

dependencies {
    val libs = project.extensions.libs
    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("androidx.compose.navigation").get())
    implementation(libs.findLibrary("kotlinx.serialization.json").get())
    implementation(libs.findLibrary("junit4").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
}