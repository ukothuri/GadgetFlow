package com.example.gadgetflow.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gadgetflow.data.api.ProductApiService
import com.example.gadgetflow.data.model.Product

// data/paging/ProductPagingSource.kt
class ProductPagingSource(
    private val apiService: ProductApiService
) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val page = params.key ?: 1
            val limit = params.loadSize
            val result = apiService.getProducts(page, limit)
            LoadResult.Page(
                data = result,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? = 1
}
