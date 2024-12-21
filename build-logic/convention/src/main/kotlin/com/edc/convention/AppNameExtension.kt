package com.edc.convention

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "com.edc.coffeenote.$name"
    }
}