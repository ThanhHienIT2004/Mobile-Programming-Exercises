package com.example.baitaplaptrinhdidong.screens.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.baitaplaptrinhdidong.R
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreenW4_Ex2(
    title: String = "",
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit)? = null,
    actionsTop: @Composable (RowScope.() -> Unit) = {},
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
                                .background(Color(0xFF03A9F4), shape = CircleShape)
                                .size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    }
                },
                actions = actionsTop
            )
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                contentColor = Color(0xFF03A9F4)
            ) {
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home") },
                    selected = false,
                    onClick = { /* TODO: Handle navigation */ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_calendar), contentDescription = "Calendar") },
                    selected = false,
                    onClick = { /* TODO: Handle navigation */ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_add), contentDescription = "Add") },
                    selected = false,

                    onClick = { /* TODO: Handle navigation */ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_document), contentDescription = "Documents") },
                    selected = false,
                    onClick = { /* TODO: Handle navigation */ }
                )
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = R.drawable.ic_setting), contentDescription = "Settings") },
                    selected = false,
                    onClick = { /* TODO: Handle navigation */ }
                )
            }
        }
    ) { padding ->
        content(padding)
    }
}
