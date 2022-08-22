package com.udacity.shoestore.shoeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailsFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewMode


class ShoeDetailsFragment : Fragment() {
    lateinit var shoeViewMode: ShoeViewMode
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeDetailsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_details_fragment, container, false
        )

        var isDonePressed = false

        shoeViewMode = ViewModelProvider(this).get(ShoeViewMode::class.java)

        binding.detailsDoneBtn.setOnClickListener { view: View ->

            val shoeName = binding.shoeNameEditText.text.toString()
            val shoeSize = binding.shoeSizeEditText.text.toString() as Double
            val shoeCompany = binding.companyEditText.text.toString()
            val shoeDescription = binding.descriptionEditText.text.toString()

            val shoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription)

            shoeViewMode.shoeList.value?.add(shoe)

        }

        shoeViewMode.isShoeListEmpty.observe(viewLifecycleOwner, Observer { isEmpty ->
            if (isEmpty) {

                val action = ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShowListFragment(shoeViewMode.shoeList.value)
            }
        })

        binding.detailsCancelBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetailsFragment_to_showListFragment)

        }





        return binding.root
    }
}