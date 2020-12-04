package com.example.project

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val repository: Repository): ViewModel() {

    val teamsList = repository.getTeamWithPlayers()
    val allPlayers = repository.getAllPlayers()

    fun addPlayer(player: Player){
        viewModelScope.launch {
            repository.insertPlayer(player)
        }
    }

    fun addTeam(team: Team){
        viewModelScope.launch {
            repository.insertTeam(team)
        }
    }

    fun deletePlayer(player: Player){
        viewModelScope.launch {
            repository.deletePlayer(player)
        }
    }

    fun deleteTeam(team: Team){
        viewModelScope.launch {
            repository.deleteTeam(team)
        }
    }

}