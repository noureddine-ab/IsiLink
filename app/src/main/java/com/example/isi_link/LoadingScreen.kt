package com.example.isi_link

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun LoadingScreen(navigateToLoginScreen : () -> Unit){
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF4804B6).copy(0.18f)).clickable { navigateToLoginScreen() }) {
        val image = painterResource(id = R.drawable.loading)
        Image(
            painter =image ,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}