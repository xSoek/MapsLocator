package com.example.retomapssave.Dao

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class Note (
        @PrimaryKey(autoGenerate=true) val id: Int = 0,
        val text: String,
        val created_at: Long = System.currentTimeMillis()
    )