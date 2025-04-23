package com.example.baitaplaptrinhdidong

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.baitaplaptrinhdidong.navHost.AppNavigation
import com.example.baitaplaptrinhdidong.screens.week7.practice.ScreenMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
//            ScreenMode()
        }
    }
}