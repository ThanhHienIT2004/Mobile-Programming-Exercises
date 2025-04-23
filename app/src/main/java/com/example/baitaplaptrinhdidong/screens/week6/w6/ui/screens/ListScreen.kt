package com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.BottomNavBar
import com.example.baitaplaptrinhdidong.screens.week6.w6.model.Task
import com.example.baitaplaptrinhdidong.screens.week6.w6.viewmodel.W6ViewModel

@Composable
fun ListScreen(navController: NavController, viewModel: W6ViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()

    Scaffold(
        topBar = { ListTopNavBar(navController) },
        bottomBar = { BottomNavBar(navController) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                if (tasks.isEmpty()) {
                    Text(
                        text = "No tasks available",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(tasks) { task ->
                            TaskItem(
                                task = task,
                                onCheckedChange = { isChecked ->
                                    viewModel.updateTask(task.copy(isCompleted = isChecked))
                                },
                                onDelete = { viewModel.deleteTask(task) }
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = onCheckedChange
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = task.title, fontWeight = FontWeight.Bold)
                Text(text = task.description)
            }
            IconButton(onClick = onDelete) {
                Icon(
                    painter = painterResource(R.drawable.ic_gg),
                    contentDescription = "Delete",
                    tint = Color.Red
                )
            }
        }
    }
}


@Composable
fun ListTopNavBar(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .offset(y = 24.dp)
    ) {
        // Tiêu đề centered in the Box
        Text(
            text = "List Screen",
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

        IconButton(
            onClick = {
                navController.navigate("w6_2")
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF2196F3), shape = RoundedCornerShape(10.dp))
                    .padding(8.dp)
            )
        }
    }
}