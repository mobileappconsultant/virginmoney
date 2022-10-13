package com.android.virginmoney.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val RETRY_BUTTON_TAG = "retryButtonTag"

@Composable
fun ErrorPage(modifier: Modifier = Modifier, message: String, onClickRetry: () -> Unit) {
    Box(modifier, contentAlignment = Alignment.Center) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(message, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onClickRetry() }, modifier = Modifier.testTag(RETRY_BUTTON_TAG)) {
                Text(text = "Retry")
            }
        }
    }
}
