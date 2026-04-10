package com.saferapps.sabiondo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.saferapps.sabiondo.app.navigation.AppNavigation
import com.saferapps.sabiondo.app.theme.SabiondoTheme


class NewMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SabiondoTheme {
                AppNavigation()
            }
        }
    }
}