package com.example.baitaplaptrinhdidong.screens.week4.w4_2.view

import android.content.Intent
import android.graphics.Color.rgb
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.NavigationGraph
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.viewmodel.TaskDetailViewModel
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.model.Attachment
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.model.Subtask
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.model.Task

@Composable
fun TaskDetailScreen(
    viewModel: TaskDetailViewModel = viewModel(),
    navController: NavController,
    taskId: Int
) {
    val taskDetail = viewModel.taskDetail.collectAsState()
    LaunchedEffect(taskId) {
        viewModel.fetchTaskById(taskId)
    }
    Scaffold(
        topBar = { TaskDetailTopBar(navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                taskDetail.value.let { task ->
                    // Task Title
                    Text(
                        text = task?.title.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    // Task Description
                    Text(
                        text = task?.description.toString(),
                        fontSize = 14.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Thông tin category, status, priority
                    TaskInfoSection(taskDetail.value)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Subtasks
                    Text(
                        text = "Subtasks",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    task?.subtasks?.forEach { subtask ->
                        SubtaskItem(subtask)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Attachments
                    Text(
                        text = "Attachments",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    task?.attachments?.forEach { attachment ->
                        AttachmentItem(attachment)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }

            }
        }
    )
}

@Composable
fun TaskDetailTopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
            .offset(y = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Nút back
        IconButton(onClick = { navController.popBackStack() }) {
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

        // Tiêu đề
        Text(
            text = "Detail",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            textAlign = TextAlign.Center
        )

        // Nút delete
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFFFA726), Color(0xFFD84315))
                        ),
                        shape = CircleShape
                    )
                    .padding(8.dp)
            )
        }
    }
}


@Composable
fun TaskInfoSection(task: Task?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(rgb(225, 187, 193)),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.category),
                contentDescription = "Category",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            if (task != null) {
                InfoCard(title = "Category", value = task.category)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.status),
                contentDescription = "Status",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            if (task != null) {
                InfoCard(title = "Status", value = task.status)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.priority),
                contentDescription = "Priority",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            if (task != null) {
                InfoCard(
                    title = "Priority",
                    value = task.priority,
                )
            }
        }
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(text = title, fontSize = 10.sp)
        Text(text = value, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SubtaskItem(subtask: Subtask) {
    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xFFE6E6E6),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                checkmarkColor = Color.White
            )
        )
        Text(
            text = subtask.title,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Composable
fun AttachmentItem(attachment: Attachment) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = Color(0xFFE6E6E6),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, attachment.fileUrl.toUri())
                context.startActivity(intent)
            }
    ) {
        Icon(
            painter = painterResource(R.drawable.document),
            contentDescription = "Notifications",
            modifier = Modifier
                .size(28.dp)
                .padding(end = 8.dp)
        )

        Text(
            text = attachment.fileName,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen2() {
    NavigationGraph()
}