package com.example.baitaplaptrinhdidong.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class UsersViewModel: ViewModel() {
    var dataTable = mutableStateListOf(
        mutableListOf("1", "Thanh Hien"),
        mutableListOf("2", "Hien Ha Ha")
    )

        private set

    fun addItem(name: String) {
        if (name.isNotBlank()) {
            val newId = (dataTable.size + 1).toString()
            dataTable.add(mutableListOf(newId, name))
        }
    }
}