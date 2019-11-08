package com.example.persistence.data.local

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retomapssave.Dao.Location
import com.example.retomapssave.Dao.LocationDao

@Database(entities = arrayOf(Location::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun locationDao(): LocationDao
}

object DatabaseFactor{
    fun get(context: Context): AppDatabase{
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
    }
}