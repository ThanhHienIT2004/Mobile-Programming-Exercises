package com.example.baitaplaptrinhdidong.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    title: String = "",
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    actionsTop: @Composable (RowScope.() -> Unit) = {},
    actionsBot: @Composable (RowScope.() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(
                            onClick = { onBackClick?.invoke() },
                            modifier = Modifier
                                .padding(10.dp)
                                .background(Color(0xFF03A9F4), shape = CircleShape) // Làm tròn nền xanh
                                .size(36.dp) // Kích thước nút
                        ) {
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color.White // Màu icon trắng
                            )
                        }
                    }
                }
                ,
                actions = actionsTop
            )
        },
        bottomBar = {
            actionsBot?.let {
                BottomAppBar (
                    modifier = Modifier.wrapContentWidth(),
                    containerColor = Color.White) { it() }
            }
        }
    ) { padding ->
        content(padding)
    }
}
