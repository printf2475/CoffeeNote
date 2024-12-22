import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.ktor)
    alias(libs.plugins.edc.android.hilt)
}

android {
    setNamespace("core.data")

    defaultConfig {
        testInstrumentationRunner = "com.edc.coffeenote.core.data.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)
}