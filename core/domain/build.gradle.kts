import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
}

android {
    setNamespace("core.domain")
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.inject)
}