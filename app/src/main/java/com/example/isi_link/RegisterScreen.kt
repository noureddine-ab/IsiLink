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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen(navigateToLoginScreen: () -> Unit) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var inputValue by remember { mutableStateOf("Function") }
    var iExpended by remember { mutableStateOf(false) }

    Box {
        val image = painterResource(id = R.drawable.back)
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
            Text(text = "Sign Up", fontSize = 32.sp)
            Text(text = "Create your new account")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(horizontal = 32.dp)
                ) {
                    OutlinedTextField(
                        value = firstname,
                        onValueChange = { firstname = it },
                        modifier = Modifier.width(150.dp),
                        label = { Text("First Name") }
                    )
                    Spacer(modifier = Modifier.width(35.dp))
                    OutlinedTextField(
                        value = lastname,
                        onValueChange = { lastname = it },
                        modifier = Modifier.width(150.dp),
                        label = { Text("Last Name") }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
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
                Spacer(modifier = Modifier.height(16.dp))
                Box {
                    // Input Button
                    Button(
                        onClick = { iExpended = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4804B6),
                            contentColor = Color.White,
                            disabledContainerColor = Color.Unspecified,
                            disabledContentColor = Color.Unspecified
                        )
                        ) {
                        Text(text = inputValue)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down",

                        )
                    }
                    DropdownMenu(expanded = iExpended, onDismissRequest = { iExpended = false }) {
                        DropdownMenuItem(
                            text = { Text(text = "Student") },
                            onClick = {
                                iExpended = false
                                inputValue = "Student"

                            })
                        DropdownMenuItem(
                            text = { Text(text = "Admin") },
                            onClick = {
                                iExpended = false
                                inputValue = "Admin"

                            })
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { navigateToLoginScreen() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4804B6),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    )
                ) {
                    Text(text = "Sign Up", fontSize = 16.sp)
                }

                Text(text = "----------------  Or sign Up with  ----------------")
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier
                            .width(64.dp)
                            .height(64.dp)
                            .padding(16.dp)

                    )
                    Image(
                        painter = painterResource(id = R.drawable.linkdin),
                        contentDescription = null,
                        modifier = Modifier
                            .width(64.dp)
                            .height(64.dp)
                            .padding(16.dp)

                    )
                    Image(
                        painter = painterResource(id = R.drawable.apple),
                        contentDescription = null,
                        modifier = Modifier
                            .width(64.dp)
                            .height(64.dp)
                            .padding(16.dp)

                    )
                }
                Row {
                    Text(text = "If you have an account? ")
                    Text(
                        text = "Sign In",
                        color = Color(0xFF4804B6),
                        modifier = Modifier.clickable { navigateToLoginScreen() })
                }

            }
        }
    }
}