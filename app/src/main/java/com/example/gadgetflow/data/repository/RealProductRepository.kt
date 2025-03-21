// data/repository/RealProductRepository.kt
package com.example.gadgetflow.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.gadgetflow.data.api.ProductApiService
import com.example.gadgetflow.data.model.Product
import com.example.gadgetflow.data.paging.ProductPagingSource

class RealProductRepository(
    private val api: ProductApiService
) : ProductRepositoryInterface {

    override fun getProducts(): Pager<Int, Product> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { ProductPagingSource(api) }
    )
}
