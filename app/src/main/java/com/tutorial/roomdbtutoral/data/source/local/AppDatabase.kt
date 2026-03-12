package com.tutorial.roomdbtutoral.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tutorial.roomdbtutoral.dao.UserDao
import com.tutorial.roomdbtutoral.models.User

@Database(entities = [User::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}