
dependencies {

    implementation("androidx.core:core-ktx:1.7.0")

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
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
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

}