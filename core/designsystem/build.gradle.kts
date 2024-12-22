import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    api(projects.core.common)
    implementation(projects.core.util)
    implementation(projects.core.model)
}