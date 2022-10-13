package com.android.virginmoney.ui.screens.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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
fun UserListItem(user: User, onItemClick: (User) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(user)
            }
            .wrapContentHeight(),
        elevation = 4.dp,
    ) {
        Row(modifier = Modifier.padding(horizontal = 16.dp), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(user.avatar, error = painterResource(id = R.drawable.avatar_default)), contentDescription = "Avatar Image"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "${user.firstName} ${user.lastName}",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primaryTextColor
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = user.jobtitle,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondaryTextColor
                )
            }
        }
    }
}
