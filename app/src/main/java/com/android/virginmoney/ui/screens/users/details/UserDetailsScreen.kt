package com.android.virginmoney.ui.screens.users.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.android.virginmoney.R
import com.android.virginmoney.domain.model.User
import com.android.virginmoney.ui.theme.primaryTextColor
import com.android.virginmoney.ui.theme.secondaryTextColor

@ExperimentalCoilApi
@Composable
fun UserDetailsScreen(user: User) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.avatar, error = painterResource(id = R.drawable.avatar_default)),
                contentDescription = "Image User",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primaryTextColor
                )
                Spacer(modifier = Modifier.height(16.dp))
                DetailsTile(type = stringResource(id = R.string.job_title), value = user.jobtitle)
                DetailsTile(type = stringResource(id = R.string.email), value = user.email)
                DetailsTile(
                    type = stringResource(id = R.string.fav_color),
                    value = user.favouriteColor
                )
                DetailsTile(
                    type = stringResource(id = R.string.created_at),
                    value = user.createdAt
                )
            }
        }
    }
}

@Composable
fun DetailsTile(type: String, value: String) {
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = type,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.secondaryTextColor
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.primaryTextColor
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
