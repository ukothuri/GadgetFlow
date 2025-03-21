package com.example.gadgetflow.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.gadgetflow.data.api.ProductApiService
import com.example.gadgetflow.data.model.Product
import com.example.gadgetflow.data.paging.ProductPagingSource

// data/repository/ProductRepository.kt
class ProductRepository(private val api: ProductApiService) {
    fun getProducts(): Pager<Int, Product> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { ProductPagingSource(api) }
    )
}
