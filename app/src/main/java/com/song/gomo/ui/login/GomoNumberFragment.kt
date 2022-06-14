package com.song.gomo.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.song.gomo.ui.base.ToolbarFragment
import com.song.gomo.databinding.FragmentGomoNumberBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GomoNumberFragment : ToolbarFragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentGomoNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGomoNumberBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}