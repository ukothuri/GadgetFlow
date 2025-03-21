package com.example.gadgetflow.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gadgetflow.presentation.productlist.ProductListScreen
import com.example.gadgetflow.presentation.productlist.ProductViewModel

sealed class Screen(val route: String) {
    object ProductList : Screen("product_list")
    // Future screens can go here, e.g.,
    // object ProductDetails : Screen("product_details/{productId}")
}

@Composable
fun MainNavGraph(
    navController: NavHostController,
    viewModel: ProductViewModel
) {
    NavHost(navController = navController, startDestination = Screen.ProductList.route) {
        composable(Screen.ProductList.route) {
            ProductListScreen(viewModel = viewModel)
        }
    }
}
