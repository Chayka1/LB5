package com.example.lb5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.room.Room
import com.example.lb5.data.database.AppDatabase
import com.example.lb5.viewmodel.ShoppingViewModel
import com.example.lb5.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "shopping-db"
        ).build()
        val dao = db.shoppingDao()
        val viewModel = ShoppingViewModel(dao)

        setContent {
            val items by viewModel.items.collectAsState()

            MainScreen(
                items = items,
                onAdd = { viewModel.addItem(it) },
                onToggle = { viewModel.toggleItem(it) },
                onDelete = { viewModel.deleteItem(it) }
            )
        }
    }
}
