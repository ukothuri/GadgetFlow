package com.example.gadgetflow.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.gadgetflow.data.repository.ProductRepository

// presentation/productlist/ProductViewModel.kt
class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    val productFlow = repository.getProducts().flow.cachedIn(viewModelScope)
}
