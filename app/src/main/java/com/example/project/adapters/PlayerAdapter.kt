package com.example.project.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.data.entities.Player
import com.example.project.databinding.PlayerItemBinding

class PlayerAdapter(var listOfPlayers: List<Player>, var listener: OnDeleteListener): RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPlayer = listOfPlayers[position]

        holder.nameTextView.text = currentPlayer.playerName
        holder.natTextView.text = currentPlayer.nationality
        holder.teamTextView.text = currentPlayer.team

        holder.delete(currentPlayer, listener)


    }

    override fun getItemCount(): Int = listOfPlayers.size

    class MyViewHolder(itemView: PlayerItemBinding): RecyclerView.ViewHolder(itemView.root) {

        val nameTextView = itemView.nameTextView
        val natTextView = itemView.natTextView
        val teamTextView = itemView.teamTextView
        val delImage = itemView.delImage

        fun delete(player: Player, listener: OnDeleteListener) {
            delImage.setOnClickListener {
                listener.deletePlayer(player)
            }
        }



    }



    interface OnDeleteListener {
        fun deletePlayer(player: Player)
    }


}