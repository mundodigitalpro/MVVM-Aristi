package com.example.mvvm_aristi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm_aristi.data.database.dao.QuoteDao
import com.example.mvvm_aristi.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}