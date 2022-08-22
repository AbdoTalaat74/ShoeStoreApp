package com.udacity.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewMode: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun newShow(shoe: Shoe){
        _shoeList.value?.add(shoe)
        _isListEmpty.value = false
        Log.i("showList","${_shoeList.value?.size}")
    }
    private val _isListEmpty = MutableLiveData<Boolean>()
    val isListEmpty: LiveData<Boolean>
    get() = _isListEmpty

    init {
        _shoeList.value = mutableListOf()
        _isListEmpty.value = true
    }


}