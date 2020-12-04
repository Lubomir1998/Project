package com.example.project.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey(autoGenerate = false)
    val teamName: String,
    val league: String
)
