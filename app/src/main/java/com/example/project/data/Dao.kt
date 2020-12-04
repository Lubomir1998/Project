package com.example.project.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team
import com.example.project.data.relations.TeamWithPlayers

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: Player)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: Team)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Delete
    suspend fun deleteTeam(team: Team)

    @Transaction
    @Query("SELECT * FROM team")
    fun getTeamWithPlayers(): LiveData<List<TeamWithPlayers>>

    @Query("SELECT * FROM player")
    fun getAllPlayers(): LiveData<List<Player>>



}