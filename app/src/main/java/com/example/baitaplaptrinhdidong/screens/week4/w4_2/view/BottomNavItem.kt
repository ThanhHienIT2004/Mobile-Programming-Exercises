package com.example.baitaplaptrinhdidong.screens.week4.w4_2.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.baitaplaptrinhdidong.R

@Composable
fun getDocumentIcon(): ImageVector {
    return ImageVector.vectorResource(id = R.drawable.ic_document)
}

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Filled.Home)
    object Date : BottomNavItem("date", "Date", Icons.Filled.DateRange)
    object Setting : BottomNavItem("setting", "Setting", Icons.Filled.Settings)
    object Document : BottomNavItem("document", "Document",Icons.Filled.Menu )

    companion object {
        fun createNewItem(route: String, title: String, icon: ImageVector): BottomNavItem {
            return NewItem(route, title, icon)
        }
    }

    class NewItem(route: String, title: String, icon: ImageVector) : BottomNavItem(route, title, icon)
}

