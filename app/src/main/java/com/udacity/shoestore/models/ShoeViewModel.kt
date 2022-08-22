package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewMode: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _isShoeListEmpty = MutableLiveData<Boolean>()
    val isShoeListEmpty: LiveData<Boolean>
        get() = _isShoeListEmpty


    private fun isEmpty(){
        if (shoeList.value?.isEmpty() == true){
            _isShoeListEmpty.value = true
        }else{
            _isShoeListEmpty.value = false
        }
    }
}