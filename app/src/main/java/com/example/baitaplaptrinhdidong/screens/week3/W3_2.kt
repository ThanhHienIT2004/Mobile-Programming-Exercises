package com.example.baitaplaptrinhdidong.screens.week3

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen
import kotlinx.coroutines.delay

val BlueColor = Color(0xFF03A9F4)

@Composable
fun W3_2(navController: NavController) {
    BaseScreen() {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.weight(0.6f))
            Image(
                painter = painterResource(R.drawable.w3bai2),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(170.dp)
            )
            Spacer(Modifier.height(20.dp))
            Text("UTH SmartTasks", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4))
            Spacer(Modifier.weight(1f))
        }

        var showPage by remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            delay(1500) // Chờ 3 giây
            showPage = true
        }

        if (showPage) {
            navController.navigate("w3_2_screen_2")
        }

    }
}

@Composable
fun BackButton(navController: NavController) {
    Button(
        onClick = { navController.popBackStack() },
        colors = ButtonDefaults.buttonColors(containerColor = BlueColor),
        modifier = Modifier
            .size(48.dp) // Đặt kích thước cố định
            .clip(CircleShape), // Đảm bảo nút có hình tròn
        contentPadding = PaddingValues(0.dp) // Loại bỏ padding mặc định để icon căn giữa
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
fun IndicatorDot(
    isSelected: Boolean,
    onClick: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isPressed) 0.5f else 1f, label = "scale")

    Box(
        modifier = Modifier
            .size(16.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(if (isSelected) BlueColor else Color.LightGray)
            .pointerInput(Unit) {
                detectTapGestures( //Phát hiện cử chỉ nhấn và thả.
                    onPress = {
                        isPressed = true
                        tryAwaitRelease() //Chờ người dùng thả tay (hoặc hủy nhấn)
                        isPressed = false
                        onClick()
                    }
                )
            }
    )
}

@Composable
fun W3_2_Screen_2(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        IndicatorDot(isSelected = true) {
                            // Already on this screen, no action needed
                        }
                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_3")
                        }
                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_4")
                        }
                    }
                    TextButton(onClick = { navController.navigate("w3_2_screen_4") }) {
                        Text("Skip", color = BlueColor)
                    }
                }
                Spacer(Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.w3bai2_1),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "Easy Time Management",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.navigate("w3_2_screen_3") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueColor)
                ) {
                    Text("Next", fontSize = 25.sp)
                }
            }
        }
    }
}

@Composable
fun W3_2_Screen_3(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_2")
                        }

                        IndicatorDot(isSelected = true) {
                        }

                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_4")
                        }
                    }
                    TextButton(onClick = { navController.navigate("w3_2_screen_4") }) {
                        Text("Skip", color = BlueColor)
                    }
                }
                Spacer(Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.w3bai2_2),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "Increase Work Effectiveness",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "Time management and the determination of more important tasks will give your job statistics better and always improve",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController)
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = { navController.navigate("w3_2_screen_4") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueColor)
                ) {
                    Text("Next", fontSize = 25.sp)
                }
            }
        }
    }
}

@Composable
fun W3_2_Screen_4(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_2")
                        }
                        IndicatorDot(isSelected = false) {
                            navController.navigate("w3_2_screen_3")
                        }
                        IndicatorDot(isSelected = true) {
                            // Already on this screen, no action needed
                        }
                    }
                }
                Spacer(Modifier.height(20.dp))
                Image(
                    painter = painterResource(R.drawable.w3bai2_3),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    "Reminder Notification",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BackButton(navController)
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = { /* Navigate to main screen */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueColor)
                ) {
                    Text("Get Started", fontSize = 25.sp)
                }
            }
        }
    }
}