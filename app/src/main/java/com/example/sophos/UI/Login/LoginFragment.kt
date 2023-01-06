package com.example.sophos.UI.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.sophos.Data.Model.LoginResponse
import com.example.sophos.R
import com.example.sophos.ViewModels.LoginViewModel
import com.example.sophos.databinding.FragmentLoginBinding
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    private val LoginViewModel : LoginViewModel by viewModels()

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var email : String
    private lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LoginViewModel.apiLoginResponse.observe(viewLifecycleOwner) { loginResponse ->
            println(loginResponse)

            run{
                if (loginResponse!!.uaccess){
                    Toast.makeText(
                        context,
                        "Bienvenido ${loginResponse.uname} ${loginResponse.ulastname}",
                        Toast.LENGTH_LONG
                    ).show()

                    findNavController().navigate(R.id.action_loginFragment_to_menu_Screen)
                } else {
                    Toast.makeText(
                        context,
                        "Usuario Discapacitado",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        binding.loginbttn.setOnClickListener {
            email = binding.Emailinput.text.toString().trim()
            password = binding.Passwordinput.text.toString().trim()

            LoginViewModel.login(
                email,
                password,
                activity as AppCompatActivity
            )
        }
    }
}