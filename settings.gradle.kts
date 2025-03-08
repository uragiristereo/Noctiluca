pluginManagement {
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
    }
}

plugins {
    id("com.android.settings") version ("8.7.3")
}

android {
    compileSdk = 34
    minSdk = 21
}

rootProject.name = "Noctiluca"

include(":app")
include(":noctiluca")
