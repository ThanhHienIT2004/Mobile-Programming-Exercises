package com.example.baitap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.screens.components.LazyButtonNav
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen

@Composable
fun MainScreen(navController: NavController) {
    BaseScreen("Bài tập hàng tuần") { padding ->
        Column (
            modifier = Modifier.padding(padding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyButtonNav(navController, 5, "Tuần", "week")
        }
    }
}
