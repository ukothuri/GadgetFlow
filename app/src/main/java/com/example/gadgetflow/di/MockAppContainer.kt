// di/MockAppContainer.kt
package com.example.gadgetflow.di

import com.example.gadgetflow.data.repository.MockProductRepository
import com.example.gadgetflow.data.repository.ProductRepositoryInterface

object MockAppContainer {
    val productRepository: ProductRepositoryInterface by lazy {
        MockProductRepository()
    }
}
