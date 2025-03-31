package com.example.baitaplaptrinhdidong.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen
import com.example.baitaplaptrinhdidong.screens.components.LazyButtonNav

@Composable
fun Week4(navController: NavController) {
    BaseScreen(
        "Tuần 4",
        true,
        onBackClick = { navController.popBackStack() }
    ) { padding ->
        Column (
            modifier = Modifier.fillMaxSize()
                .wrapContentSize(Alignment.TopCenter)
                .padding(padding)
        ) {
            LazyButtonNav(navController, 2, "Bài", "w4")
        }
    }
}