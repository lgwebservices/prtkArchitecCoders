package com.webservice.prontoticket.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.webservice.prontoticket.screens.detail.DetailScreen
import com.webservice.prontoticket.screens.detail.DetailViewModel
import com.webservice.prontoticket.screens.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onEventoClick = { evento ->
                navController.navigate("detail/${evento.id}")
            })
        }
        composable(
            route = "detail/{eventoId}",
            arguments = listOf(navArgument("eventoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val eventoId = requireNotNull(backStackEntry.arguments?.getInt("eventoId"))
            DetailScreen(
                viewModel { DetailViewModel(eventoId) },
                onBack = { navController.popBackStack() })
        }
    }
}