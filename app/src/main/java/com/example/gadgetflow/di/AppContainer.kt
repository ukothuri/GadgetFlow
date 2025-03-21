// com.example.gadgetflow.di.AppContainer.kt
package com.example.gadgetflow.di

import com.example.gadgetflow.data.api.ProductApiService
import com.example.gadgetflow.data.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppContainer {

    // Base URL for all network calls
    private const val BASE_URL = "https://api.restful-api.dev/"

    // Retrofit instance (singleton)
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // API service (singleton)
    val productApiService: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }

    // Repository (singleton)
    val productRepository: ProductRepository by lazy {
        ProductRepository(productApiService)
    }
}
