package com.example.persistence.data.local

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ContactsContract.CommonDataKinds.Note::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    //abstract fun notesDao(): NotesDao
}

object DatabaseFactor{
    fun get(context: Context): AppDataBase{
        return Room
            .databaseBuilder(context, AppDataBase::class.java, "app_database")
            .build()
    }
}