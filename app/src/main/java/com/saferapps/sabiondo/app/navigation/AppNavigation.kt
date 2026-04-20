package com.saferapps.sabiondo.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.saferapps.sabiondo.activity.MainActivity
import com.saferapps.sabiondo.app.screens.home.HomeScreen
import com.saferapps.sabiondo.app.screens.login_screen.LoginScreen
import com.saferapps.sabiondo.app.screens.register.RegisterScreen


@Composable
fun AppNavigation() {

    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "login") {

        composable("login") {
            LoginScreen(onNavigateToRegister = { nav.navigate("register") })
        }

        composable("home") {
            HomeScreen()
        }
        composable("main") {
            MainActivity()
        }
        composable("register") {
            RegisterScreen()
        }
    }
}