import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
    id("com.android.application")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Noctiluca"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":noctiluca"))

            implementation(compose.material)
            implementation(compose.material3)
        }

        androidMain.dependencies {
            implementation("androidx.activity:activity-compose:1.9.3")
            implementation(compose.preview)
        }
    }
}

android {
    namespace = "com.uragiristereo.noctiluca.app"

    defaultConfig {
        applicationId = "com.uragiristereo.noctiluca.app"
        targetSdk = 34
        versionCode = 100
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
