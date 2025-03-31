package com.example.baitaplaptrinhdidong.screens.week4.w4_2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.ui.theme.PoppinsFont

@Composable
fun FirstIntroduction(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indicator dots
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(
                                if (index == 0) Color(0xFF006EE9) else Color(0xFFEEF5FD)
                            )
                    )
                }
            }

            Text(
                text = "skip",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                ),
                color = Color(0xFF006EE9),
                modifier = Modifier.clickable { navController.navigate(BottomNavItem.Home.route) }
            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.size(320.dp, 420.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.portfolio_update),
                contentDescription = "Easy Time Management",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Easy Time Management",
                style = TextStyle(
                    fontWeight = FontWeight(500),
                    fontSize = 18.sp,
                    fontFamily = PoppinsFont,
                ),
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "With management based on priority and daily tasks, " +
                        "it will give you convenience in managing and determining " +
                        "the tasks that must be done first ",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color(0xFF4A4646),
                    fontFamily = PoppinsFont,
                    fontWeight = FontWeight(400),
                    lineHeight = 22.sp,
                ),
                modifier = Modifier
                    .size(320.dp)
            )
        }

        Button(
            onClick = { navController.navigate("secondIntroduction") },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007BFF)
            ),
            modifier = Modifier
                .size(350.dp, 53.dp)
        ) {
            Text(
                text = "Next",
                color = Color.White,
                fontWeight = FontWeight(700),
                fontSize = 20.sp
            )
        }
    }
}