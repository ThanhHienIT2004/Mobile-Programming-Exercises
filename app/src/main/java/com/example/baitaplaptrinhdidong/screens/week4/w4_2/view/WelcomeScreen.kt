package com.example.baitaplaptrinhdidong.screens.week4.w4_2.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.ui.theme.RighteousFont
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("firstIntroduction") {
            popUpTo("welcome") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.w3bai2),
            contentDescription = "UTH Smart Tasks",
            modifier = Modifier.size(200.dp, 80.dp)
        )

        Text(
            text = "UTH Smart Tasks",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = RighteousFont,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF006EE9),
            ),
            modifier = Modifier.padding(16.dp)

        )
    }
}