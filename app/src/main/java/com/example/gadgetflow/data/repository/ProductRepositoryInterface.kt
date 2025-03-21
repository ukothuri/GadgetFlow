// data/repository/ProductRepositoryInterface.kt
package com.example.gadgetflow.data.repository

import androidx.paging.Pager
import com.example.gadgetflow.data.model.Product

interface ProductRepositoryInterface {
    fun getProducts(): Pager<Int, Product>
}
