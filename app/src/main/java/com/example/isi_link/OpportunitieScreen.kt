package com.example.isi_link

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class OpportunitiesItem(
    val id: Int,
    var name: String,
    var detail: String

)

@Composable
fun OpportunitiesScreen(navigateToProfileScreen : () -> Unit , navigateToOthersScreen: ()->Unit) {
    var sItems by remember { mutableStateOf(listOf<OpportunitiesItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemDetail by remember { mutableStateOf("") }

    Box {
        val image = painterResource(id = R.drawable.back2)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column {
            Spacer(modifier = Modifier.height(85.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    items(sItems) { item ->
                        OppListItem(item = item, onDeleteClick = {
                            sItems -= item
                        })


                    }
                }
                Column {
                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4804B6),
                            contentColor = Color.White,
                            disabledContainerColor = Color.Unspecified,
                            disabledContentColor = Color.Unspecified
                        )
                    ) {
                        Text(text = "Add Event")
                    }
                    Column(
                        modifier = Modifier
                            .background(color = Color.White, RoundedCornerShape(16.dp))
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = null,
                                modifier = Modifier.clickable { },
                                tint = Color(0xFF4804B6)
                            )
                            Icon(
                                Icons.Default.Send,
                                contentDescription = null,
                                modifier = Modifier.clickable { })
                            Icon(
                                Icons.Default.Info,
                                contentDescription = null,
                                modifier = Modifier.clickable {navigateToOthersScreen() })
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.clickable {navigateToProfileScreen() }
                            )
                        }
                    }
                }

            }
        }
    }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            if (itemName.isNotBlank()) {
                                val newItem = OpportunitiesItem(
                                    id = sItems.size + 1,
                                    name = itemName,
                                    detail = itemDetail
                                )
                                sItems += newItem
                                itemName = ""
                                itemDetail = ""
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4804B6),
                            contentColor = Color.White,
                            disabledContainerColor = Color.Unspecified,
                            disabledContentColor = Color.Unspecified
                        )
                    ) {
                        Text(text = "Add")
                    }

                    Button(
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4804B6),
                            contentColor = Color.White,
                            disabledContainerColor = Color.Unspecified,
                            disabledContentColor = Color.Unspecified
                        )
                    ) {
                        Text(text = "Cancel")
                    }

                }
            },
            title = { Text(text = "Add Event") },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    OutlinedTextField(
                        value = itemDetail,
                        onValueChange = { itemDetail = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            }
        )
    }

}

@Composable
fun OppListItem(
    item: OpportunitiesItem,
    onDeleteClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0xFF4804B6)),
                shape = RoundedCornerShape(20)
            ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = item.name, modifier = Modifier.padding(8.dp))
            IconButton(onClick = { onDeleteClick() }) {
                Icon(
                    imageVector = Icons.Default.Delete, contentDescription = null,
                    tint = Color(0xFF4804B6)
                )
            }
        }
        Text(text = item.detail, modifier = Modifier.padding(8.dp))

    }
}