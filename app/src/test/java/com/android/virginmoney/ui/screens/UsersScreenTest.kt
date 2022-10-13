package com.android.virginmoney.ui.screens

import android.os.Build
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.espresso.IdlingRegistry
import com.android.virginmoney.ui.MainActivity
import com.android.virginmoney.ui.composable.RETRY_BUTTON_TAG
import com.android.virginmoney.ui.dispatchers.SuccessDispatcher
import com.android.virginmoney.ui.screens.users.LIST_TEST_TAG
import com.android.virginmoney.utils.AndroidXIdlingResource
import com.android.virginmoney.utils.CoroutineTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import java.lang.Thread.sleep
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    manifest = Config.NONE,
    sdk = [Build.VERSION_CODES.LOLLIPOP],
    application = HiltTestApplication::class
)
class UsersScreenTest {

    @get:Rule(order = 0)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var mockWebServer: MockWebServer

    private val dispatcher = SuccessDispatcher()

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Before
    fun setup() {
        ShadowLog.stream = System.out

        hiltTestRule.inject()
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = dispatcher
        mockWebServer.start(8080)
        IdlingRegistry.getInstance().register(
            (
                AndroidXIdlingResource.asAndroidX(
                    OkHttp3IdlingResource.create(
                        "okhttp",
                        okHttpClient
                    )
                )
                )
        )
    }

    @Test
    fun `given when application is launched and people network request is made, then it should show the list`() =
        runTest {
            dispatcher.emptyResult = false
            dispatcher.hasError = false
            mockWebServer.dispatcher = dispatcher
            composeTestRule.apply {
                activityRule.scenario.onActivity {
                    sleep(4000)
                    onNodeWithTag(RETRY_BUTTON_TAG).performClick()
                    sleep(4000)
                    onRoot(useUnmergedTree = true).printToLog("ListLog")
                    onAllNodesWithTag(LIST_TEST_TAG).onFirst().assertExists()
                }
            }
        }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }
}
