package com.example.baitaplaptrinhdidong.screens.week3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen
import kotlinx.coroutines.delay

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
                    .size(20.dp)
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
            W3_2_Screen_2(navController)
        }

    }
}

@Composable
fun W3_2_Screen_2(navController: NavController) {
    BaseScreen(
        actionsBot = {
            Button(onClick = { navController.navigate("w3_2_screen_3")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("Next", fontSize = 20.sp)
            }
        }
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Box() {
                Image(
                    painter = painterResource(R.drawable.w3bai2_1),
                    contentDescription = "Icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(500.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Easy Time Management", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                    Spacer(Modifier.height(20.dp))

                    Text("With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
                        textAlign = TextAlign.Center, fontSize = 14.sp, color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun W3_2_Screen_3(navController: NavController) {
    BaseScreen(
        actionsBot = {
            Row(
                Modifier.height(90.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f).fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(56.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFF03A9F4)),
                        tint = Color.White
                    )
                }

                Button(onClick = { navController.navigate("w3_ex2_page_3")},
                    modifier = Modifier
                        .weight(4f)
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
                ) {
                    Text("Next", fontSize = 20.sp)
                }
            }

        }
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.w3bai2_2),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
            )

            Spacer(Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Increase Work Effectiveness", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                Text("Time management and the determination of more important tasks will give your job statistics better and always improve",
                    textAlign = TextAlign.Center, fontSize = 14.sp, color = Color.Gray
                )
            }

        }
    }
}

@Composable
fun W3_2_Screen_4(navController: NavController) {
    BaseScreen(
        actionsBot = {
            Row(
                Modifier.height(90.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f).fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(56.dp)
                            .clip(shape = CircleShape)
                            .background(Color(0xFF03A9F4)),
                        tint = Color.White
                    )
                }

                Button(onClick = { navController.navigate("w4_1_screen_2")},
                    modifier = Modifier
                        .weight(4f)
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
                ) {
                    Text("Get Started", fontSize = 20.sp)
                }
            }

        }
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.w3bai2_3),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
            )

            Spacer(Modifier.height(20.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Reminder Notification", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                Text("The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
                    textAlign = TextAlign.Center, fontSize = 14.sp, color = Color.Gray
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev32w3() {
    val navController = rememberNavController()
    W3_2_Screen_3(navController)
}