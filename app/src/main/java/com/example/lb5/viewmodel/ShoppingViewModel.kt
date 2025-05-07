package com.example.lb5.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lb5.data.database.ShoppingDao
import com.example.lb5.data.model.ShoppingItem
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ShoppingViewModel(private val dao: ShoppingDao) : ViewModel() {

    val items: StateFlow<List<ShoppingItem>> = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addItem(name: String) {
        viewModelScope.launch {
            dao.insert(ShoppingItem(name = name))
        }
    }

    fun toggleItem(item: ShoppingItem) {
        viewModelScope.launch {
            dao.update(item.copy(isChecked = !item.isChecked))
        }
    }

    fun deleteItem(item: ShoppingItem) {
        viewModelScope.launch {
            dao.delete(item)
        }
    }
}
