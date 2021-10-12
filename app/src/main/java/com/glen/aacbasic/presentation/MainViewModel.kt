package com.glen.aacbasic.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glen.aacbasic.data.Flower
import com.glen.aacbasic.data.FlowerRepository
import com.glen.aacbasic.data.FlowerRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: FlowerRepository = FlowerRepositoryImpl()

    private val _retryCount = MutableLiveData(0)
    val retryCount: LiveData<Int> = _retryCount

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _flowers = MutableLiveData<List<Flower>>(emptyList())
    val flowers: LiveData<List<Flower>> = _flowers

    val toastEvent = SingleLiveEvent<String>()


    init {
        updateFlowers()
    }


    fun onRetryButtonClicked() {
        updateFlowers()
    }

    private fun updateFlowers() {
        viewModelScope.launch {
            _isLoading.value = true
            _flowers.value = null

            _flowers.value = repository.fetchFlowers()
            _retryCount.value = (_retryCount.value ?: 0) + 1
            _isLoading.value = false
            toastEvent.value = "Update done"
        }
    }
}