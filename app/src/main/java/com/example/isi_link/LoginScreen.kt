package com.example.isi_link

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateToHomeScreen : ()-> Unit, navigateToRegisterScreen:()-> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box {
        val image = painterResource(id = com.example.isi_link.R.drawable.back)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sign In", fontSize = 32.sp)
            Text(text = "Hi ! Welcome back, you have been missed.")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = "Forgot Password?", color = Color(0xFF4804B6))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { navigateToHomeScreen()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4804B6),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    )
                ) {
                    Text(text = "Sign In", fontSize = 16.sp)
                }
            }

            Text(text = "----------------  Or sign in with  ----------------")
            Row {
                Image(
                    painter = painterResource(id = com.example.isi_link.R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(16.dp)

                )
                Image(
                    painter = painterResource(id = com.example.isi_link.R.drawable.linkdin),
                    contentDescription = null,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(16.dp)

                )
                Image(
                    painter = painterResource(id = com.example.isi_link.R.drawable.apple),
                    contentDescription = null,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .padding(16.dp)

                )
            }
            Row {
                Text(text = "Don't have an account? ")
                Text(text = "Sign Up" , modifier = Modifier.clickable { navigateToRegisterScreen() })
            }

        }
    }
}