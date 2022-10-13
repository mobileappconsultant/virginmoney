plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = "com.android.people"
    compileSdk = 32
    apply(from = "$rootDir/android-library.kts")

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core"))
}
