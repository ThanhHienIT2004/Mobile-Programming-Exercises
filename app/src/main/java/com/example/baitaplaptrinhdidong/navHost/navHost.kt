package com.example.baitaplaptrinhdidong.navHost

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import com.example.baitaplaptrinhdidong.screens.week3.W3_1_Section_1
import com.example.baitaplaptrinhdidong.screens.week3.W3_2
import com.example.baitaplaptrinhdidong.screens.week3.W3_2_Screen_2
import com.example.baitaplaptrinhdidong.screens.week3.W3_2_Screen_3
import com.example.baitaplaptrinhdidong.screens.week3.W3_2_Screen_4
import com.example.baitaplaptrinhdidong.screens.week4.W4_1
import com.example.baitaplaptrinhdidong.screens.week4.W4_1_Screen_2
import com.example.baitaplaptrinhdidong.screens.week4.W4_1_Screen_3
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.NavigationGraph
import com.example.baitaplaptrinhdidong.screens.week5.w5_1.screens.ProfileScreen
import com.example.baitaplaptrinhdidong.screens.week5.w5_1.W5_1
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.AddNewScreen
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.ListScreen
import com.example.baitaplaptrinhdidong.screens.week7.practice.ScreenMode

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
        composable("week_6") { Week6(navController) }
        composable("week_7") { Week7(navController) }



        // Tuần 2
        composable("w2_1") { W2_1(navController) }
            composable("w2_1_screen_2") { W3_1_Screen_2(navController) }
        composable("w2_2") { W2_2(navController) }

        // Tuần 3
        composable("w3_1") { W3_1(navController) }
            composable("w3_1_section_2") { W3_1_Section_1(navController) }
            composable("w3_1_screen_3") { W3_1_Screen_3(navController) }




        // Tuần 3
            composable(
                route = "w3_2",
                enterTransition = { fadeIn(animationSpec = tween(1700)) }, // Fade vào khi vào màn hình
                exitTransition = { fadeOut(animationSpec = tween(1700)) }  // Fade ra khi rời màn hình
            ) { W3_2(navController) }

            composable(
                route = "w3_2_screen_2",
                enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(1500)) }, // Trượt từ phải sang trái
                exitTransition = { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(1500)) }, // Trượt ra bên trái
                popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(1500)) }, // Trượt từ trái khi quay lại
                popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(1500)) } // Trượt ra bên phải khi thoát
            ) { W3_2_Screen_2(navController) }

            composable(
                route = "w3_2_screen_3",
                enterTransition = { slideInVertically(initialOffsetY = { it }, animationSpec = tween(1500)) }, // Trượt từ dưới lên
                exitTransition = { slideOutVertically(targetOffsetY = { -it }, animationSpec = tween(1500)) }, // Trượt ra trên
                popEnterTransition = { slideInVertically(initialOffsetY = { -it }, animationSpec = tween(1500)) }, // Trượt từ trên xuống khi quay lại
                popExitTransition = { slideOutVertically(targetOffsetY = { it }, animationSpec = tween(1500)) } // Trượt ra dưới khi thoát
            ) { W3_2_Screen_3(navController) }

            composable(
                route = "w3_2_screen_4",
                enterTransition = { fadeIn(animationSpec = tween(700)) + scaleIn(initialScale = 0.5f, animationSpec = tween(1400)) }, // Fade + scale vào
                exitTransition = { fadeOut(animationSpec = tween(700)) + scaleOut(targetScale = 0.5f, animationSpec = tween(1400)) }, // Fade + scale ra
                popEnterTransition = { fadeIn(animationSpec = tween(700)) }, // Fade vào khi quay lại
                popExitTransition = { fadeOut(animationSpec = tween(700)) } // Fade ra khi thoát
            ) { W3_2_Screen_4(navController) }




        // Tuần 4
        composable("w4_1") { W4_1(navController) }
            composable("w4_1_screen_2") { W4_1(navController) }
            composable("w4_1_screen_3") { W4_1_Screen_2(navController) }
            composable("w4_1_screen_4") { W4_1_Screen_3(navController) }

        composable("w4_2") { NavigationGraph() }

        // Tuần 5
        composable("w5_1") { W5_1(navController) }
            composable("w5_1_profile") { ProfileScreen(navController) }

        //Tuần 6
        composable("w6_1") {  ListScreen(navController) }
            composable("w6_2") {  AddNewScreen(navController) }

        //Tuần 7
        composable("w7") {  ScreenMode() }


    }
}