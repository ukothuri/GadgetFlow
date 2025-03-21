// presentation/productlist/ProductViewModelFactory.kt
package com.example.gadgetflow.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gadgetflow.data.repository.ProductRepositoryInterface

class ProductViewModelFactory(
    private val repository: ProductRepositoryInterface
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}
