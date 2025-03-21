package com.example.gadgetflow.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gadgetflow.data.api.ProductApiService
import com.example.gadgetflow.data.repository.ProductRepository
import com.example.gadgetflow.presentation.productlist.ProductListScreen
import com.example.gadgetflow.presentation.productlist.ProductViewModel
import com.example.gadgetflow.presentation.productlist.ProductViewModelFactory
import com.example.gadgetflow.ui.theme.GadgetFlowTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(
            ProductRepository(
                Retrofit.Builder()
                    .baseUrl("https://api.restful-api.dev/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProductApiService::class.java)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GadgetFlowTheme {
                ProductListScreen(viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GadgetFlowTheme {
        Greeting("Android")
    }
}