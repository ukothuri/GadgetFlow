// data/repository/MockProductRepository.kt
package com.example.gadgetflow.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gadgetflow.data.model.Product

class MockProductRepository : ProductRepositoryInterface {
    override fun getProducts(): Pager<Int, Product> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { MockPagingSource() }
    )
}

class MockPagingSource : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val dummyList = List(10) {
            Product(
                id = it.toString(),
                name = "Mock Product $it",
                data = mapOf("color" to "Black", "capacity" to "${64 + it} GB")
            )
        }
        return LoadResult.Page(
            data = dummyList,
            prevKey = null,
            nextKey = 2
        )
    }
}
