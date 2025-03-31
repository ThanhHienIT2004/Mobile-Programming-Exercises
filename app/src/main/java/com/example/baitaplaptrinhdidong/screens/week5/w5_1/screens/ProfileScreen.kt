package com.example.baitaplaptrinhdidong.screens.week5.w5_1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser

    val accountName by remember { mutableStateOf(currentUser?.displayName ?: "") }
    val email by remember { mutableStateOf(currentUser?.email ?: "") }
    val photoUrl by remember { mutableStateOf(currentUser?.photoUrl?.toString() ?: "") }
    val dateOfBirth by remember { mutableStateOf("25/02/2004") } // Giả lập, chưa có dữ liệu


    BaseScreen(
        showBackButton = true,
        onBackClick = { navController.popBackStack() },
        actionsTop = {
            Spacer(Modifier.weight(1f))
            Text("Profile", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4)
            )
            Spacer(Modifier.weight(1f))
        },
        actionsBot = {
            Button(onClick = { navController.popBackStack()},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("Back", fontSize = 20.sp)
            }
        }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {

            Image(
                painter = if(photoUrl.isNotEmpty()){
                    rememberAsyncImagePainter(model = photoUrl)
                }else{
                    painterResource(R.drawable.bai1)
                },
                    contentDescription = "Avatar Google Account",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // TextInput cho name
            Text(
                text = "Name",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            OutlinedTextField(
                value = accountName,
                onValueChange = { /* Không làm gì vì đã vô hiệu hóa */ },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Gray,
                    disabledLabelColor = Color.Gray
                )
            )

            // TextInput cho email
            Text(
                text = "Email",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = { /* Không làm gì vì đã vô hiệu hóa */ },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Gray,
                    disabledLabelColor = Color.Gray
                )
            )
            // TextInput cho dob
            Text(
                text = "Date of Birth",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            OutlinedTextField(
                value = dateOfBirth,
                onValueChange = { /* Không làm gì vì đã vô hiệu hóa */ },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = Color.Black,
                    disabledBorderColor = Color.Gray,
                    disabledLabelColor = Color.Gray
                )
            )
        }
    }

}
