package com.saferapps.sabiondo.app.navigation

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.*
import com.saferapps.sabiondo.activity.MainActivity
import com.saferapps.sabiondo.app.screens.home.HomeScreen
import com.saferapps.sabiondo.app.screens.login_screen.LoginScreen
import com.saferapps.sabiondo.app.screens.register.RegisterScreen
import com.saferapps.sabiondo.helper.SessionHandler


@Composable
fun AppNavigation() {

    val context = LocalContext.current
    val session = remember { SessionHandler(context) }
    val isLoggedIn = remember { session.isLoggedIn() }

    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = if (isLoggedIn) "main_redirect" else "login"
    ) {

        composable("login") {
            LoginScreen(onNavigateToRegister = { nav.navigate("register") })
        }

        composable("main_redirect") {
            LaunchedEffect(Unit) {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()
            }
        }

        composable("home") {
            HomeScreen()
        }
        composable("register") {
            RegisterScreen(onNavigateToLogin = { nav.navigate("login") })
        }
    }
}