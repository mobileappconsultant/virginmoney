package com.android.virginmoney.ui.screens.users

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.domain.model.User

@ExperimentalCoilApi
@Composable
fun UsersList(users: List<User>, onItemClick: (User) -> Unit) {
    LazyColumn {
        items(users) { user ->
            UserListItem(user = user, onItemClick)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
