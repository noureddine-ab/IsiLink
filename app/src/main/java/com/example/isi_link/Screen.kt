package com.example.isi_link

sealed class Screen (val route : String) {
    object LoginScreen : Screen ("loginscreen")
    object RegisterScreen : Screen ("registerscreen")
    object LoadingScreen : Screen ("loadingscreen")
    object HomeScreen : Screen ("homescreen")
    object ProfileScreen : Screen ("profilescreen")
    object AboutScreen : Screen ("Aboutscreen")
    object AboutScreen2 : Screen ("Aboutscreen2")
}