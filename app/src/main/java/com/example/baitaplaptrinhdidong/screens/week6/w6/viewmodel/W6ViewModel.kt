package com.example.baitaplaptrinhdidong.screens.week6.w6.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitaplaptrinhdidong.screens.week6.w6.AppDatabase
import com.example.baitaplaptrinhdidong.screens.week6.w6.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class W6ViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao = AppDatabase.getDatabase(application).taskDao()

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    init {
        viewModelScope.launch {
            taskDao.getAllTasks().collect { tasks ->
                _tasks.value = tasks
            }
        }
    }

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            val newTask = Task(title = title, description = description)
            taskDao.insert(newTask)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskDao.update(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }
}