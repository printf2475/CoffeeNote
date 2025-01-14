package com.edc.coffeenote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme
import com.edc.coffeenote.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeNoteTheme {
                AppNavHost()
            }
        }
    }
}