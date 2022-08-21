package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle?): View {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,
                                                                    container,false)

        binding.loginBtn.setOnClickListener{ view: View->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.createAccount.setOnClickListener{view:View ->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return binding.root
    }
}