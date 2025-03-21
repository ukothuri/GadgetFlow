package com.example.gadgetflow.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.gadgetflow.data.repository.ProductRepository
import com.example.gadgetflow.data.repository.ProductRepositoryInterface

// presentation/productlist/ProductViewModel.kt
// ProductViewModel.kt
class ProductViewModel(
    private val repository: ProductRepositoryInterface
) : ViewModel() {

    val productFlow = repository.getProducts().flow.cachedIn(viewModelScope)
}
