package com.udacity.shoestore.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewMode


class ShoeDetailsFragment : Fragment() {
//    lateinit var shoeViewMode: ShoeViewMode
    private val viewMode:ShoeViewMode by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeDetailsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_details_fragment, container, false
        )
        binding.shoe = Shoe("NA", 0.0, "NA", "NA")


//        shoeViewMode = ViewModelProvider(this).get(ShoeViewMode::class.java)

        binding.detailsDoneBtn.setOnClickListener {

            viewMode.newShow(binding.shoe)

        }

        binding.detailsCancelBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetailsFragment_to_showListFragment)

        }


        return binding.root
    }
}