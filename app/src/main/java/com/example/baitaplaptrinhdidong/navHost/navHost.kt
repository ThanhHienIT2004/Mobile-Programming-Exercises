package com.example.baitaplaptrinhdidong.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitap.screens.MainScreen
import com.example.baitap.screens.Week2
import com.example.baitaplaptrinhdidong.screens.*
import com.example.baitaplaptrinhdidong.screens.week2.W2_1
import com.example.baitaplaptrinhdidong.screens.week2.W2_2
import com.example.baitaplaptrinhdidong.screens.week3.W3_1
import com.example.baitaplaptrinhdidong.screens.week3.W3_1_Screen_2
import com.example.baitaplaptrinhdidong.screens.week3.W3_1_Screen_3
import com.example.baitaplaptrinhdidong.screens.week3.W3_2
import com.example.baitaplaptrinhdidong.screens.week3.W3_1_Section_1
import com.example.baitaplaptrinhdidong.screens.week4.W4_1
import com.example.baitaplaptrinhdidong.screens.week4.W4_1_Screen_2
import com.example.baitaplaptrinhdidong.screens.week4.W4_1_Screen_3
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.NavigationGraph
import com.example.baitaplaptrinhdidong.screens.week5.w5_1.screens.ProfileScreen
import com.example.baitaplaptrinhdidong.screens.week5.w5_1.W5_1

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        // Màn hình chính
        composable("home") {
            MainScreen(navController)
        }

        // Điều hướng đến các tuần
        composable("week_2") { Week2(navController) }
        composable("week_3") { Week3(navController) }
        composable("week_4") { Week4(navController) }
        composable("week_5") { Week5(navController) }

        // Tuần 2
        composable("w2_1") { W2_1(navController) }
            composable("w2_1_screen_2") { W3_1_Screen_2(navController) }
        composable("w2_2") { W2_2(navController) }

        // Tuần 3
        composable("w3_1") { W3_1(navController) }
            composable("w3_1_section_2") { W3_1_Section_1(navController) }
            composable("w3_1_screen_3") { W3_1_Screen_3(navController) }
        composable("w3_2") { W3_2(navController) }

        // Tuần 4
        composable("w4_1") { W4_1(navController) }
            composable("w4_1_screen_2") { W4_1(navController) }
            composable("w4_1_screen_3") { W4_1_Screen_2(navController) }
            composable("w4_1_screen_4") { W4_1_Screen_3(navController) }

        composable("w4_2") { NavigationGraph() }

        // Tuần 5
        composable("w5_1") { W5_1(navController) }
            composable("w5_1_profile") { ProfileScreen(navController) }


    }
}