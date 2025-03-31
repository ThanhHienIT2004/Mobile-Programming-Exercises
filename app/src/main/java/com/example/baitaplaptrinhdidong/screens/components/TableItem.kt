package com.example.baitaplaptrinhdidong.screens.components

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TableItem(titleTable: List<String>, dataTable: List<List<String>>) {
    // title
    Surface (
        modifier = Modifier.fillMaxWidth(0.9f).height(40.dp)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .border(3.dp, Color(0xFFE1CFF6), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        color = Color(0xFFE1CFF6),

        ) {
        Row (
            modifier = Modifier.fillMaxWidth().border(2.dp, Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            titleTable.forEach { data ->
                Text(data, fontSize = 16.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f).wrapContentWidth())
            }
        }
    }

    // data cell
    Surface (
        modifier = Modifier.fillMaxWidth(0.9f).fillMaxHeight(0.9f)
            .clip(shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            .border(3.dp, Color(0xFFEFE9FA), shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
        color = Color(0xFFEFE9FA)
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
        ) {
            dataTable.forEach { row ->
                Row (modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    row.forEach { cell ->
                        Text(cell, fontSize = 16.sp, fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f).wrapContentWidth())
                    }
                }
            }
        }
    }
}