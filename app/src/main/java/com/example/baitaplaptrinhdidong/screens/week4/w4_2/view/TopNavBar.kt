package com.example.uthsmarttasks.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baitaplaptrinhdidong.R

@Composable
fun TopNavBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .offset(y = 24.dp),
    ) {
        // Logo bên trái
        Image(
            painter = painterResource(id = R.drawable.uth_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(64.dp)
                .padding(end = 12.dp)
        )

        // Tên ứng dụng và mô tả
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "SmartTasks",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp, // Tăng kích thước chữ
                color = Color(0xFF2196F3)
            )
            Text(
                text = "A simple and efficient to-do app",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        // Biểu tượng chuông với badge
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 8.dp) // Thêm padding bên phải
        ) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(28.dp) // Điều chỉnh kích thước icon
            )

            // Badge đỏ nhỏ
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color.Red, CircleShape)
                    .align(Alignment.TopEnd)
            )
        }
    }
}