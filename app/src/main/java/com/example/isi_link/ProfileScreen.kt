package com.example.isi_link

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(navigateToOthersScreen : ()->Unit,navigateToHomeScreen : () -> Unit) {
    val name = "Helena Hills"
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    Box {
        val image = painterResource(id = R.drawable.back2)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Edit Profile", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(Color.Gray, CircleShape),
                        contentDescription = "Profile picture"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Text(
                            "Change profile photo",
                            modifier = Modifier.clickable {
                                // Handle profile picture change
                            },
                            color = Color.Gray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Username", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Email", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Bio", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = bio,
                    onValueChange = { bio = it },
                    modifier = Modifier.height(190.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4804B6),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    )) {
                    Text("Save changes")

                }
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
                        modifier = Modifier.clickable { navigateToHomeScreen()})
                    Icon(
                        Icons.Default.Send,
                        contentDescription = null,
                        modifier = Modifier.clickable { })
                    Icon(
                        Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.clickable { navigateToOthersScreen()})
                    Icon(
                        Icons.Default.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.clickable { },
                        tint = Color(0xFF4804B6)
                    )
                }
            }
        }
    }
}