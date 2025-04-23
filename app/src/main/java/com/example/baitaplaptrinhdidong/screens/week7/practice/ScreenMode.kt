package com.example.baitaplaptrinhdidong.screens.week7.practice

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.BottomNavBar
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.EmptyTaskScreen
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.AddNewTopBar
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.ListTopNavBar

@Composable
fun ScreenMode (){
    Scaffold(
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Setting", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center )
                    Text("Choosing the right theme sets the tone and personality of your app",  textAlign = TextAlign.Center )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row (modifier = Modifier
                        ,Arrangement.SpaceBetween){
                        Button(modifier = Modifier
                            .size(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue,
                            ),
                            onClick = {}){
                        }

                        Button(modifier = Modifier
                            .size(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Green,
                            ),
                            onClick = {}){
                        }

                        Button(modifier = Modifier
                            .size(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                            ),
                            onClick = {}){
                        }
                    }

                }
            }
        }
    )
}