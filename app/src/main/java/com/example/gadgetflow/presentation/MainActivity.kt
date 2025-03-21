package com.example.gadgetflow.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.gadgetflow.di.AppContainer
import com.example.gadgetflow.presentation.navigation.MainNavGraph
import com.example.gadgetflow.presentation.productlist.ProductViewModel
import com.example.gadgetflow.presentation.productlist.ProductViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ProductViewModelFactory(AppContainer.productRepository)
            .create(ProductViewModel::class.java)

        setContent {
            val navController = rememberNavController()
            MainNavGraph(navController = navController, viewModel = viewModel)
        }
    }
}

