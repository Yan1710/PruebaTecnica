package com.example.pruebatecnica.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnica.data.room.Daos.CommentDao
import com.example.pruebatecnica.data.room.Daos.PostDao
import com.example.pruebatecnica.data.room.entity.CommentEntity
import com.example.pruebatecnica.data.room.entity.PostEntity

@Database(
    entities = [PostEntity::class, CommentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao
}