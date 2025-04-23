package com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.BottomNavBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.baitaplaptrinhdidong.screens.week6.w6.viewmodel.W6ViewModel

@Composable
fun AddNewScreen(navController: NavController, viewModel: W6ViewModel = viewModel()) {
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = { AddNewTopBar(navController) },
        bottomBar = { BottomNavBar(navController) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    Text("Task", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = taskTitle,
                        onValueChange = { taskTitle = it },
                        placeholder = { Text("Do homework") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Description", fontWeight = FontWeight.Bold)
                    OutlinedTextField(
                        value = taskDescription,
                        onValueChange = { taskDescription = it },
                        placeholder = { Text("Don't give up") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        maxLines = 4
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {
                                if (taskTitle.isNotBlank()) {
                                    viewModel.addTask(taskTitle, taskDescription)
                                    navController.popBackStack()
                                }
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .width(200.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF1E90FF),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(24.dp)
                        ) {
                            Text("Add")
                        }
                    }
                }
            }
        }
    )
}
@Composable
fun AddNewTopBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .offset(y = 24.dp)
    ) {
        // Tiêu đề centered in the Box
        Text(
            text = "Add New",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )

        // Nút back aligned to start, overlaid on top
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_back2),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF2196F3), shape = RoundedCornerShape(10.dp))
                    .padding(8.dp)
            )
        }
    }
}