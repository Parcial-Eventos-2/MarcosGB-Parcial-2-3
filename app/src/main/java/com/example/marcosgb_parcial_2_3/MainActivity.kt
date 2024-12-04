package com.example.marcosgb_parcial_2_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marcosgb_parcial_2_3.ui.theme.AppTheme
import com.example.marcosgb_parcial_2_3.vista.PantallaListaFarmacias
import com.example.marcosgb_parcial_2_3.vista.PantallaMapa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController, startDestination = "lista") {
        composable("lista") {
            PantallaListaFarmacias(navController)
        }
        composable("mapa/{latitud}/{longitud}") { backStackEntry ->
            val latitud = backStackEntry.arguments?.getString("latitud")?.toDoubleOrNull() ?: 0.0
            val longitud = backStackEntry.arguments?.getString("longitud")?.toDoubleOrNull() ?: 0.0
            PantallaMapa(latitud, longitud)
        }
    }
}
