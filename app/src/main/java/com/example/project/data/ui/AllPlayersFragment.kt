package com.example.project.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.MainViewModel
import com.example.project.R
import com.example.project.adapters.PlayerAdapter
import com.example.project.adapters.TeamAdapter
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team
import com.example.project.data.relations.TeamWithPlayers
import com.example.project.databinding.AddTeamsBinding
import com.example.project.databinding.AllPlayersFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllPlayersFragment: Fragment(R.layout.all_players_fragment) {

    private lateinit var binding: AllPlayersFragmentBinding
    private val model: MainViewModel by viewModels()

    private var listPlayers = listOf<Player>()
    private lateinit var listener: PlayerAdapter.OnDeleteListener
    private lateinit var mAdapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AllPlayersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = object : PlayerAdapter.OnDeleteListener {

            override fun deletePlayer(player: Player) {
                model.deletePlayer(player)
            }
        }

        mAdapter = PlayerAdapter(listPlayers, listener)

        model.allPlayers.observe(requireActivity(), {
            listPlayers = it
            displayData(listPlayers)
        })


        binding.playersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            setHasFixedSize(true)
        }


        binding.addPlayerImg.setOnClickListener {
            findNavController().navigate(R.id.action_allPlayersFragment_to_addPlayerFragment)
        }

    }





    private fun displayData(list: List<Player>){
        mAdapter.listOfPlayers = list
        mAdapter.notifyDataSetChanged()
    }

}