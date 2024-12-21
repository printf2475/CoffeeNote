import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.library)
    alias(libs.plugins.edc.android.compose)
}

android {
    setNamespace("core.common")
}

dependencies {
    api(projects.core.model)
    api(projects.core.util)
}