package com.udacity.shoestore.shoeList

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeCardBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewMode

class ShoeListFragment: Fragment() {
    private val viewMode: ShoeViewMode by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment,
                                                                        container,false)

        setHasOptionsMenu(true)

        binding.floatingBtn.setOnClickListener{view: View->
                Navigation.findNavController(view).navigate(R.id.action_showListFragment_to_shoeDetailsFragment)
        }
        viewMode.isListEmpty.observe(viewLifecycleOwner, Observer {  bool ->
            if(!bool){
                viewMode.shoeList.value?.forEach(){ shoe ->
                    val bindingCard:ShoeCardBinding = DataBindingUtil.inflate(inflater,
                        R.layout.shoe_card,container,false)
                    bindingCard.shoe = shoe
                    binding.shoeListLayout.addView(bindingCard.root)

                }

            }
        })

        return binding.root


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}