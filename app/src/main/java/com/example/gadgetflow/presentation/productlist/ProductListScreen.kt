package com.example.gadgetflow.presentation.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gadgetflow.data.model.Product

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {
    val products = viewModel.productFlow.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(products.itemCount) { index ->
            val product: Product? = products[index]
            product?.let {
                ProductItemCard(it)
            }
        }

        // Handle loading and error states
        products.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { CenteredProgress() }
                }

                loadState.append is LoadState.Loading -> {
                    item { CenteredProgress() }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = loadState.refresh as LoadState.Error
                    item {
                        Text(
                            text = "Error: ${error.error.localizedMessage}",
                            color = Color.Red,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductItemCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.data?.entries
                    ?.joinToString("\n") { "${it.key}: ${it.value}" }
                    ?: "No details",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun CenteredProgress() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
