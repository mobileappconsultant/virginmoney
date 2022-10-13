plugins {
    id(Plugins.androidApplication)
    kotlin(Plugins.android)
    kotlin(Plugins.kapt)
    id(Plugins.parcelize)
    id(Plugins.hilt)
    id(Plugins.jacoco)
}

android {
    compileSdk = 33
    apply(from = "$rootDir/android-library.kts")

    lint {
        abortOnError = false
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    defaultConfig {
        applicationId = "com.android.virginmoney"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.android.virginmoney.HiltTestRunner"
    }
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://61e947967bc0550017bc61bf.mockapi.io/\"")
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://61e947967bc0550017bc61bf.mockapi.io/\"")
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
}

dependencies {
    implementation(project(":people"))
    implementation(project(":rooms"))

    implementation(Kotlin.core)
    implementation(Compose.ui)
    implementation(Compose.hilt)
    implementation(Compose.uiTooling)
    implementation(Compose.livedata)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.materialIconsCore)
    implementation(Compose.materialIconExtended)
    implementation(Compose.accompanistPermission)
    implementation("androidx.lifecycle:lifecycle-process:2.4.1")
    implementation("androidx.paging:paging-common-ktx:3.1.1")
    implementation(project(mapOf("path" to ":core")))
    androidTestImplementation(Compose.composeUiTest)

    implementation(Timber.library)
    implementation(Navigation.navigation)
    implementation(Navigation.navigationUI)

    implementation(Kotlin.coroutines)
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutineReactive)

    testImplementation(Tests.coreTesting)
    testImplementation(Tests.core)
    testImplementation(Tests.coroutineTest)
    testImplementation(Tests.robolectric)
    testImplementation(Tests.mockk)
    testImplementation(Tests.extJUnit)
    testImplementation(Tests.espressoCore)
    testImplementation(Tests.junit)
    testImplementation(Tests.composeUiTest)
    testImplementation(Tests.hiltTesting)
    testImplementation(Tests.mockWebServer)
    testImplementation(Tests.idling)
    kaptTest(Tests.hiltCompiler)
    debugImplementation(Tests.composeDebugTest)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    kapt(Hilt.hiltCompiler)

    // Retrofit
    implementation("com.google.code.gson:gson:2.9.1")
    implementation(Compose.coil)
    implementation(Compose.paging)
    implementation(Compose.swipeRefresh)

    implementation(Joda.joda)
}

jacoco {
    toolVersion = Build.jacocoVersion
}
