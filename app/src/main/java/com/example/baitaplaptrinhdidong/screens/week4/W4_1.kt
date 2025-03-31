package com.example.baitaplaptrinhdidong.screens.week4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen

@Composable
fun W4_1(navController: NavController) {
    BaseScreen(
        showBackButton = true,
        onBackClick = { navController.popBackStack() },
        actionsBot = {
            Button(
                onClick = { navController.navigate("w4_ex1_page_1") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("Push", fontSize = 20.sp)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Image(
                painter = painterResource(R.drawable.w3bai1),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Spacer(Modifier.height(50.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Navigation", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                Text(
                    "Jetpack Compose is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in an app.",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

// -------------------------------- Page 1 -----------------------------------
@Composable
fun W4_1_Screen_2(navController: NavController) {
    BaseScreen(
        showBackButton = true,
        onBackClick = { navController.popBackStack() },
        actionsTop = {
            Spacer(Modifier.weight(1f))
            Text(
                "LazyColumn", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4)
            )
            Spacer(Modifier.weight(1f))
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(10.dp)
        ) {
            LazyColumn {
                items(W4_1_GetData()) { description ->
                    CustomBox(
                        description = description,
                        onClick = { navController.navigate("W4_ex1_page_2") }
                    )
                }
            }
        }
    }
}

fun W4_1_GetData(): List<String> {
    return listOf(
        "01 | Displays text elements that can be styled and formatted in various ways, including size, color, and weight.",
        "02 | Displays an image from a resource or URL, allowing for customization of size, scale, and shape.",
        "03 | Provides a field for text input, supporting features like placeholder text, character limits, and real-time validation.",
        "04 | Similar to a text field but used specifically for password input, often with an option to toggle visibility.",
        "05 | A layout container that arranges child elements in a vertical sequence, useful for stacking UI components.",
        "06 | A layout container that arranges child elements in a horizontal sequence, ideal for placing items side by side.",
        "07 | A flexible box layout that automatically wraps elements based on available space, providing a responsive UI.",
        "08 | A scrollable column layout that allows content to extend beyond the screen, enabling vertical scrolling.",
        "09 | A horizontal scrolling row that supports dynamic content such as image carousels or horizontally scrollable lists.",
        "10 | A clickable button element that triggers an action when pressed, customizable in terms of appearance and behavior.",
        "11 | A text field with an outlined border for input, providing better visual separation from the background.",
        "12 | A checkbox input element that allows users to select one or multiple options in a list of choices.",
        "13 | A switch button that toggles between two states, often used for enabling or disabling settings.",
        "14 | A selectable radio button that allows users to choose only one option from a predefined set of choices.",
        "15 | A draggable slider control for selecting a value within a given range, commonly used for volume or brightness adjustments."
    )
}


// ✅ CustomBox chỉ hiển thị mô tả
@Composable
fun CustomBox(description: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp) // Căn lề đẹp hơn
            .clickable { onClick() }
            .background(Color(0xFFD2EBFF), shape = RoundedCornerShape(15.dp)) // Màu nền xanh nhạt
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = description,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f) // Đẩy icon về bên phải
        )

        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = Modifier.size(24.dp).background(color = Color.Black, shape = RoundedCornerShape(6.dp))
        )
    }
}


@Composable
fun W4_1_Screen_3(navController: NavController) {
    BaseScreen(
        showBackButton = true,
        onBackClick = { navController.popBackStack() },
        actionsTop = {
            Spacer(Modifier.weight(1f))
            Text(
                "Detail", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4)
            )
            Spacer(Modifier.weight(1f))
        },
        actionsBot = {
                Button(
                    onClick = { navController.popBackStack("w4_1", inclusive = false) },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
                ) {
                    Text("BACK TO ROOT", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Câu trích dẫn trên cùng
            Text(
                text = "“The only way to do great work is to love what you do”",
                fontSize = 18.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            // Hình ảnh trích dẫn
            Image(
                painter = painterResource(R.drawable.w4bai1), // Thay bằng ID ảnh thực tế
                contentDescription = "Quote Image",
                modifier = Modifier
                    .width(350.dp)  // Điều chỉnh chiều rộng ảnh
                    .height(450.dp) // Điều chỉnh chiều cao ảnh
            )
        }
    }
}
