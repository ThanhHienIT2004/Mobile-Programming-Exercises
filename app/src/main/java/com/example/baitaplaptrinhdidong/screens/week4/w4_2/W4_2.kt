package com.example.baitaplaptrinhdidong.screens.week4.w4_2

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.FirstIntroduction
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.HomeScreen
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.SecondIntroduction
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.TaskDetailScreen
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.WelcomeScreen
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.BottomNavItem
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.DateScreen
import com.example.baitaplaptrinhdidong.screens.week4.w4_2.view.SettingScreen
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.AddNewScreen
import com.example.baitaplaptrinhdidong.screens.week6.w6.ui.screens.ListScreen
import com.example.uthsmarttasks.view.ThirdIntroduction

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("firstIntroduction") {
            FirstIntroduction(navController)
        }
        composable("secondIntroduction") {
            SecondIntroduction(navController)
        }
        composable("thirdIntroduction") {
            ThirdIntroduction(navController)
        }
        composable(BottomNavItem.Home.route) { HomeScreen(navController = navController) }
        composable(BottomNavItem.Document.route) { ListScreen(navController = navController) }
        composable(BottomNavItem.AddNew.route) { (AddNewScreen(navController = navController)) }
        composable(BottomNavItem.Setting.route) { (SettingScreen()) }
        composable(BottomNavItem.Date.route) { DateScreen() }

        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull() ?: 0
            TaskDetailScreen(navController = navController, taskId = taskId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    NavigationGraph()
}
