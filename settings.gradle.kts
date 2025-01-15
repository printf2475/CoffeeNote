pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}


rootProject.name = "CoffeeNote"

include(":app")

// core
include(":core:common")
include(":core:util")
include(":core:designsystem")
include(":core:data")
include(":core:model")
include(":core:domain")
include(":core:database")

// feature
include(":feature:home")
include(":feature:coffee_been")
