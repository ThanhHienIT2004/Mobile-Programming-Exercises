package com.example.baitaplaptrinhdidong.screens.week4.w4_2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BottomNavBar(
    navController: NavController
//    onFabClick: () -> Unit
) {
    val documentIcon = getDocumentIcon()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Date,
        BottomNavItem.createNewItem("document", "Document", documentIcon),
        BottomNavItem.Setting,
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    Box(
        Modifier
            .fillMaxWidth()
            .offset(y = (-16).dp)
            .padding(8.dp),
        contentAlignment = Alignment.BottomCenter,

        ) {
        // Background của Bottom Navigation
        Surface(
            color = Color.White,
            shadowElevation = 8.dp,
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {

            // Navigation Items
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    if (index == items.size / 2) {
                        Spacer(modifier = Modifier.width(56.dp)) // Chừa chỗ cho FAB
                    }
                    IconButton(
                        onClick = {
//                            selectedItem = index
//                            navController.navigate(item.route)
                        }
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (selectedItem == index) Color(0xFF2196F3) else Color.Gray,
                            modifier = Modifier.size(28.dp),
                        )
                    }
                }
            }
        }
        // Floating Action Button
        FloatingActionButton(
            onClick = {},
            containerColor = Color(0xFF2196F3),
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(64.dp)
                .offset(y = (-32).dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(28.dp),
            )
        }
    }
}

