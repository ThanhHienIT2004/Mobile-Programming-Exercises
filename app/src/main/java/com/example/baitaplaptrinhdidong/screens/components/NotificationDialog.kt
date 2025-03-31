package com.example.baitaplaptrinhdidong.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotiDialog(text: String,showDialog: Boolean ,onDismiss: () -> Unit) {

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            text = {
                Text(
                    text,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                    .wrapContentSize()
                )
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }
}
