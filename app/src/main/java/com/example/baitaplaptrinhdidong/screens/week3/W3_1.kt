package com.example.baitaplaptrinhdidong.screens.week3

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.screens.base.BaseScreen

@Composable
fun W3_1(navController: NavController) {
    BaseScreen(
        showBackButton = true,
        onBackClick = { navController.popBackStack() },
        actionsBot = {
            Button(onClick = { navController.navigate("w3_1_screen_2")},
                modifier = Modifier.fillMaxWidth()
                    .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03A9F4))
            ) {
                Text("I'm Ready", fontSize = 20.sp)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {
            Image(
                painter = painterResource(R.drawable.w3bai1),
                contentDescription = "Icon",
                modifier = Modifier.fillMaxWidth().size(250.dp)
            )

            Spacer(Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Jetpack Compose", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(Modifier.height(20.dp))

                Text("Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                    textAlign = TextAlign.Center, fontSize = 14.sp, color = Color.Gray
                )
            }
        }
    }
}

// -------------------------------- page 1 -----------------------------------
@Composable
fun W3_1_Screen_2(navController: NavController) {
    BaseScreen(
        actionsTop = {
            Spacer(Modifier.weight(1f))
            Text("UI Components List", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4)
            )
            Spacer(Modifier.weight(1f))
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
                .padding(10.dp)
        ) {
            W3_1_Section_1(navController)
        }
    }
}

@Composable
fun W3_1_Section_1(navController: NavController) {
    val contentList = listOf(
        "Display", listOf(
            listOf("Text", "Displays text"),
            listOf("Image", "Displays an image")
        ),
        "Input", listOf(
            listOf("TextField", "Input field for text"),
            listOf("PasswordField", "Input field for passwords")
        ),
        "Layout", listOf(
            listOf("Column", "Arranges elements vertically"),
            listOf("Row", "Arranges elements horizontally")
        )
    )

    contentList.forEach { item ->
        when (item) {
            is String -> {
                Text(text = item, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 10.dp))
            }

            is List<*> -> {
                item.forEach { subItem ->
                    if (subItem is List<*>) {
                        Card(
                            modifier = Modifier.fillMaxWidth()
                                .padding(vertical = 5.dp)
                                .clickable { navController.navigate("w3_2_screen_3")},
                            colors = CardDefaults.cardColors(Color(0xFF6ACCF8))
                        ) {
                            Column(
                                modifier = Modifier.padding(10.dp, 15.dp)
                            ) {
                                Text(
                                    text = "${subItem[0]}",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(10.dp, 2.dp)
                                )
                                Text(
                                    "${subItem[1]}", fontSize = 20.sp,
                                    modifier = Modifier.padding(10.dp, 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// ----------------------------------- page 2 ------------------------------------------
@Composable
fun W3_1_Screen_3(navController: NavController) {
    BaseScreen(
        showBackButton = true,
        onBackClick = {navController.popBackStack()},
        actionsTop = {
            Spacer(Modifier.weight(1f))
            Text("UI Components List", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                color = Color(0xFF03A9F4)
            )
            Spacer(Modifier.weight(1f))
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            StyledText()
        }
    }
}

@Composable
fun StyledText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 30.sp)) {append("The ")}
            withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {append("quick ")}
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFF9C6B2F))) {
                append("Brown")
            }
            append("\n")

            withStyle(style = SpanStyle(fontSize = 30.sp)) {
                append("fox j u m p s ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)) {
                append("over")
            }
            append("\n")

            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("the")
            }
            withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                append(" lazy")
            }
            append(" dog.")
        },
        fontSize = 30.sp,
        lineHeight = 40.sp
    )
}

@Preview(showBackground = true)
@Composable
fun Prev3w3() {
////    val navController = rememberNavController()
////    W3_Exercise1(navController)
//    W3_Ex1_Page2()
}