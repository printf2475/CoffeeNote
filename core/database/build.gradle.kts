import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.hilt)
    alias(libs.plugins.edc.android.room)
}

android {
    setNamespace("core.database")
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.gson)
}