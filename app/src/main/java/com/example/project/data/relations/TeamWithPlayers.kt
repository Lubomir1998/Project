package com.example.project.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team

data class TeamWithPlayers(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamName",
        entityColumn = "team"
    )
    val players: List<Player>
)
