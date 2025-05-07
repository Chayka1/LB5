package com.example.lb5.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lb5.data.model.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}
