import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.ktor)
    alias(libs.plugins.edc.android.hilt)
}

android {
    setNamespace("core.data")
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)
}