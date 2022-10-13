plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin(Plugins.kapt)
    id(Plugins.parcelize)
    id(Plugins.hilt)
}

android {
    namespace = "com.android.core"
    compileSdk = 32
    apply(from = "$rootDir/android-library.kts")

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://61e947967bc0550017bc61bf.mockapi.io/\"")
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://61e947967bc0550017bc61bf.mockapi.io/\"")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    kapt(Hilt.hiltCompiler)

    // Retrofit
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.gson)
    implementation(Retrofit.logging)

    implementation(Compose.coil)
    implementation(Compose.paging)
    implementation(Compose.swipeRefresh)

    implementation(Room.room)
    implementation(Room.roomKtx)
    implementation(Room.roomPaging)
    kapt(Room.roomKapt)
    implementation(Browser.browser)
    implementation(Joda.joda)
}
