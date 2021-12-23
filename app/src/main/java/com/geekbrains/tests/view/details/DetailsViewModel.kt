package com.geekbrains.tests.view.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel(private var count: Int = 0) : ViewModel() {

    private val _liveData = MutableLiveData<Int>()
    private val liveData: LiveData<Int> = _liveData

    fun subscribeToLiveData() = liveData

    fun setCounter(count: Int) {
        this.count = count
        _liveData.postValue(this.count)
    }

    fun onIncrement() {
        _liveData.postValue(++count)
    }

    fun onDecrement() {
        _liveData.postValue(--count)
    }
}
