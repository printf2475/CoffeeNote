import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.model")
}

dependencies {
    api(projects.core.util)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.runtime.android)
}