package com.android.virginmoney.ui.dispatchers

import com.android.virginmoney.utils.FileReader
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class SuccessDispatcher : Dispatcher() {
    var emptyResult = false
    var hasError = false
    override fun dispatch(request: RecordedRequest): MockResponse {
        return if (hasError) {
            MockResponse().setResponseCode(500)
                .setBody(FileReader.readStringFromFile("success_response_empty.json"))
        } else if (emptyResult) {
            MockResponse().setResponseCode(200)
                .setBody(FileReader.readStringFromFile("success_response_empty.json"))
        } else {
            MockResponse().setResponseCode(200)
                .setBody(FileReader.readStringFromFile("success_response.json"))
        }
    }
}
