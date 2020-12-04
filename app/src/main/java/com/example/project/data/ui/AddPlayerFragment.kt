package com.example.project.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.project.MainViewModel
import com.example.project.R
import com.example.project.data.entities.Player
import com.example.project.databinding.AddPlayerFragmentBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPlayerFragment: Fragment(R.layout.add_player_fragment) {

    private lateinit var binding: AddPlayerFragmentBinding
    private val model: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddPlayerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addPlayer.setOnClickListener {
            addPlayers()
        }

        binding.addTeamsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_addPlayerFragment_to_addTeamsFragment)
        }



    }





    private fun addPlayers(){
        val name = binding.playerNameEditText.text.trim().toString()
        val nationality = binding.playerNatEditText.text.trim().toString()
        val team = binding.playerTeamEditText.text.trim().toString()

        val player = Player(name, nationality, team)

        if(binding.playerNameEditText.text.trim().isNotEmpty() && binding.playerNatEditText.text.trim().isNotEmpty() && binding.playerTeamEditText.text.trim().isNotEmpty()) {
            model.addPlayer(player)

            binding.playerNameEditText.text.clear()
            binding.playerNatEditText.text.clear()
            binding.playerTeamEditText.text.clear()

            Snackbar.make(requireView(), "Player added", Snackbar.LENGTH_LONG).show()
        }
        else{
            Snackbar.make(requireView(), "All fields must be filled", Snackbar.LENGTH_LONG).show()
        }


    }











}