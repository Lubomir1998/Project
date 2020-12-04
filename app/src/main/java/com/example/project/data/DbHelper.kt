package com.example.project.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team

@Database(
    entities = [Player::class, Team::class],
    version = 1
)
abstract class DbHelper: RoomDatabase() {

    abstract fun getDao(): Dao

}