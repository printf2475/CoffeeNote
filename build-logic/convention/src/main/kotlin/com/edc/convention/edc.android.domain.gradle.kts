import com.edc.convention.configureKotlinAndroid
import gradle.kotlin.dsl.accessors._4b055a01bae563bd2c86a468691a3401.implementation


plugins {
    id("edc.android.library")
}

configureKotlinAndroid()

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
}