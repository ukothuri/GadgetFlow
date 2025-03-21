package com.example.gadgetflow.data.api

import com.example.gadgetflow.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Query

// data/api/ProductApiService.kt
interface ProductApiService {
    @GET("objects")
    suspend fun getProducts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<Product>
}
