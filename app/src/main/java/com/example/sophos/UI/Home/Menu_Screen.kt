package com.example.sophos.UI.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sophos.R
import com.example.sophos.databinding.FragmentLoginBinding
import com.example.sophos.databinding.FragmentMenuScreenBinding

class Menu_Screen : Fragment() {
    private var _binding : FragmentMenuScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMenuScreenBinding.inflate(inflater, container, false)
        return binding.root
        // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOffices.setOnClickListener {
            findNavController().navigate(R.id.action_menu_Screen_to_officesFragment)
        }
    }

}