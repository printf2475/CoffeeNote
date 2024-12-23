import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.hilt)
}

android {
    setNamespace("core.domain")

    defaultConfig {
        testInstrumentationRunner = "com.edc.coffeenote.core.domain.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.inject)
}