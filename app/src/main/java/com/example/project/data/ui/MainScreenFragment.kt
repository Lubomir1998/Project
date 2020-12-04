package com.example.project.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.MainViewModel
import com.example.project.R
import com.example.project.adapters.TeamAdapter
import com.example.project.data.entities.Team
import com.example.project.data.relations.TeamWithPlayers
import com.example.project.databinding.MainScreenFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment: Fragment(R.layout.main_screen_fragment) {

    private lateinit var binding: MainScreenFragmentBinding
    private val model: MainViewModel by viewModels()
    private var listTeams = listOf<TeamWithPlayers>()
    private lateinit var listener: TeamAdapter.AddListener
    private lateinit var mAdapter: TeamAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = object : TeamAdapter.AddListener {

            override fun deleteTeam(team: Team) {
                model.deleteTeam(team)
            }
        }

        mAdapter = TeamAdapter(listTeams, listener)


        binding.addPlayerImg.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_addPlayerFragment)
        }

        model.teamsList.observe(requireActivity(), {
            displayData(it)
        })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            setHasFixedSize(true)
        }






    }

    private fun displayData(list: List<TeamWithPlayers>){
        mAdapter.listOfTeams = list
        mAdapter.notifyDataSetChanged()
    }


}