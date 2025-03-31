package com.example.baitaplaptrinhdidong.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LazyButtonNav(navController: NavController, size: Int, nameBtnLabel: String, nameScreen: String) {
    val buttonLabels = (1..size).map { "$nameBtnLabel $it" }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // ✅ Khoảng cách giữa các nút
    ) {
        items(buttonLabels) { label ->
            OutlinedButton( // ✅ Bỏ nền, chỉ giữ viền
                onClick = { navController.navigate("${nameScreen}_${label.last()}") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp), // ✅ Căn chỉnh padding
                shape = RoundedCornerShape(12.dp), // ✅ Bo góc mềm mại
                colors = ButtonDefaults.outlinedButtonColors() // ✅ Giữ màu mặc định (không nền)
            ) {
                Text(label)
            }
        }
    }
}
