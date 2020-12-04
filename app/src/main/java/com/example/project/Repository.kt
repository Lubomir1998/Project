package com.example.project

import com.example.project.data.Dao
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team
import javax.inject.Inject

class Repository @Inject constructor(private val dao: Dao){

    suspend fun insertPlayer(player: Player) = dao.insertPlayer(player)

    suspend fun insertTeam(team: Team) = dao.insertTeam(team)

    suspend fun deletePlayer(player: Player) = dao.deletePlayer(player)

    suspend fun deleteTeam(team: Team) = dao.deleteTeam(team)

    fun getTeamWithPlayers() = dao.getTeamWithPlayers()




}