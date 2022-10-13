package com.android.virginmoney.ui.screens.rooms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.R
import com.android.virginmoney.domain.model.Room
import com.android.virginmoney.ui.theme.primaryTextColor
import com.android.virginmoney.ui.theme.secondaryTextColor

@ExperimentalCoilApi
@Composable
fun RoomsListItem(room: Room) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 8.dp,
    ) {
        Column(
            Modifier
                .padding(16.dp)
        ) {
            val occupiedText = if (room.isOccupied) R.string.occupied else R.string.not_occupied
            val occupiedColor = if (room.isOccupied) Color.Red else Color.Green

            Text(
                text = "Room Id: ${room.id}",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primaryTextColor
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Max Occupancy: ${room.maxOccupancy}",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.secondaryTextColor
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Status: ${stringResource(id = occupiedText)}",
                style = MaterialTheme.typography.body1,
                color = occupiedColor
            )
        }
    }
}
