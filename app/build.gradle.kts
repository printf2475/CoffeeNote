plugins {
    alias(libs.plugins.edc.android.application)
    alias(libs.plugins.edc.android.config)
}

android {
    namespace = "com.edc.coffeenote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.edc.coffeenote"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.util)
    implementation(projects.core.designsystem)
    implementation(projects.feature.home)
    implementation(projects.feature.coffee)


    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.profileinstaller)
}