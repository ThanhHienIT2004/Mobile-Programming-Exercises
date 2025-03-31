package com.example.baitaplaptrinhdidong.screens.week2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen
import com.example.baitaplaptrinhdidong.screens.components.NotiDialog

@Composable
fun W2_1(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableIntStateOf(0) }
    var result by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    BaseScreen (
        "Thực hành 01",
        true,
        onBackClick = { navController.popBackStack() }
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(10.dp))

            Spacer(Modifier.height(20.dp))
            Text("Thực hành 01", fontSize = 38.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize())

            Spacer(Modifier.height(10.dp))
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(30.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text("Họ và tên", fontSize = 20.sp)
                    Spacer(Modifier.width(30.dp))
                    OutlinedTextField (
                        value = name,
                        onValueChange = {name = it},
                        label = {},
                        singleLine = true
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Tuổi", fontSize = 20.sp)
                    Spacer(Modifier.width(79.dp))
                    OutlinedTextField (
                        value = if(age <= 0) "" else age.toString(),
                        onValueChange = {
                            if (it.all { char -> char.isDigit() }) {
                                age = it.toIntOrNull() ?: 0
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = {},
                        singleLine = true
                    )
                }
            }

            // Button
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = {
                    when {
                        age > 65 -> result = "Người già"
                        age in 6..65 -> result = "Người lớn"
                        age in 2..6-> result = "Trẻ em"
                        age > 0 && age < 2-> result = "Em bé"
                        else -> result = "Không hợp lệ"
                    }

                    showDialog = true

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
            ) {
                Text("Kiểm tra")
            }

            // Thông báo
            if (showDialog) {
                NotiDialog(result, showDialog) { showDialog = false }
            }
        }
    }
}