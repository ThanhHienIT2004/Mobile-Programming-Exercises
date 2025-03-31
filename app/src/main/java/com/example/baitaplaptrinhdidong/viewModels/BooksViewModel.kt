package com.example.baitaplaptrinhdidong.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BooksViewModel : ViewModel() {
    var dataTable = mutableStateListOf(
        mutableListOf("1", "Sach 1"),
        mutableListOf("2", "Sach 2")
    )

        private set

    fun addItem(name: String) {
        if (name.isNotBlank()) {
            val newId = (dataTable.size + 1).toString()
            dataTable.add(mutableListOf(newId, name))
        }
    }
}