import com.edc.convention.setNamespace

plugins {
    alias(libs.plugins.edc.android.feature)
}

android {
    setNamespace("feature.home")
}