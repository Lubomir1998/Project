package com.example.project.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey(autoGenerate = false)
    val playerName: String,
    val nationality: String,
    val team: String
)
