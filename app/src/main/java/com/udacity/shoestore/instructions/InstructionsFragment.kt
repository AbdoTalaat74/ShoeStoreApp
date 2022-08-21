package com.udacity.shoestore.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding
class InstructionsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionFragmentBinding =
            DataBindingUtil.inflate(inflater,R.layout.instruction_fragment,container,false)
        binding.instructionNextBtn.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_instructionsFragment_to_showListFragment)
        }
        return binding.root
    }
}