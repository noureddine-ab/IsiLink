package com.example.isi_link

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoadingScreen.route) {
        composable(Screen.LoadingScreen.route) {
            LoadingScreen {
                navController.navigate(Screen.LoginScreen.route)
            }
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen({
                navController.navigate(Screen.HomeScreen.route)
            },
                {
                    navController.navigate(Screen.RegisterScreen.route)

                })
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen {
                navController.navigate(Screen.LoginScreen.route)
            }
        }
        composable(Screen.HomeScreen.route) {
            OpportunitiesScreen({
                navController.navigate(Screen.ProfileScreen.route)
            }, {
                navController.navigate(Screen.AboutScreen.route)
            })
        }
        composable(Screen.AboutScreen.route) {
            OthersScreen({
                navController.navigate(Screen.HomeScreen.route)
            }, {
                navController.navigate(Screen.ProfileScreen.route)
            }, {
                navController.navigate(Screen.AboutScreen2.route)
            }
            )
        }
        composable(Screen.AboutScreen2.route) {
            OthersScreen2({
                navController.navigate(Screen.HomeScreen.route)
            }, {
                navController.navigate(Screen.ProfileScreen.route)
            }, {
                navController.navigate(Screen.AboutScreen.route)
            })
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen({
                navController.navigate(Screen.AboutScreen.route)
            }, {
                navController.navigate(Screen.HomeScreen.route)
            })
        }
    }
}