package com.example.project.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.project.MainViewModel
import com.example.project.R
import com.example.project.data.entities.Player
import com.example.project.data.entities.Team
import com.example.project.databinding.AddPlayerFragmentBinding
import com.example.project.databinding.AddTeamsBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddTeamsFragment: Fragment(R.layout.add_teams) {


    private lateinit var binding: AddTeamsBinding
    private val model: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addTeam.setOnClickListener {
            addTeams()
        }


    }








    private fun addTeams(){
        val name = binding.teamNameEditText.text.trim().toString()
        val league = binding.leagueEditText.text.trim().toString()

        val team = Team(name, league)

        if(binding.teamNameEditText.text.trim().isNotEmpty() && binding.leagueEditText.text.trim().isNotEmpty()) {
            model.addTeam(team)

            binding.teamNameEditText.text.clear()
            binding.leagueEditText.text.clear()

            Snackbar.make(requireView(), "Team added", Snackbar.LENGTH_LONG).show()
        }
        else{
            Snackbar.make(requireView(), "All fields must be filled", Snackbar.LENGTH_LONG).show()
        }


    }


}