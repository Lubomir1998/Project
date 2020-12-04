package com.example.project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.data.entities.Team
import com.example.project.data.relations.TeamWithPlayers
import com.example.project.databinding.TeamItemBinding

class TeamAdapter(var listOfTeams: List<TeamWithPlayers>, var listener: AddListener): RecyclerView.Adapter<TeamAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = TeamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTeam = listOfTeams[position]

        holder.teamTextView.text = currentTeam.team.teamName
        holder.leagueTextView.text = currentTeam.team.league

        if(currentTeam.players.size > 2) {
            holder.dots.visibility = View.VISIBLE
        }
        else{
            holder.dots.visibility = View.GONE
        }

        if(currentTeam.players.isNotEmpty()) {
            holder.firstPlayerTextView.text = currentTeam.players.first().playerName
        }

        if(currentTeam.players.size > 1) {
            if(currentTeam.players.isNotEmpty()) {
                holder.lastPlayerTextView.text = currentTeam.players.last().playerName
            }
        }

        holder.delete(currentTeam.team, listener)


    }

    override fun getItemCount(): Int = listOfTeams.size

    class MyViewHolder(itemView: TeamItemBinding): RecyclerView.ViewHolder(itemView.root) {

        val teamTextView = itemView.teamtextView
        val leagueTextView = itemView.leagueTextView
        val dots = itemView.dotsTextView
        val firstPlayerTextView = itemView.firstPlayerTextView
        val lastPlayerTextView = itemView.lastPlayerTextView
        val deleteImg = itemView.deleteImg

        fun delete(team: Team, listener: AddListener) {
            deleteImg.setOnClickListener {
                listener.deleteTeam(team)
            }
        }



    }



    interface AddListener {
        fun deleteTeam(team: Team)
    }


}