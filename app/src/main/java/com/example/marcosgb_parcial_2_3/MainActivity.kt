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
import com.example.marcosgb_parcial_2_3.vista.PantallaLogin
import com.example.marcosgb_parcial_2_3.vista.PantallaRegistro
import com.google.firebase.auth.FirebaseAuth

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
    val auth = FirebaseAuth.getInstance()

    NavHost(navController, startDestination = "login") {
        // Pantalla de Login
        composable("login") {
            PantallaLogin(navController, auth)
        }
        // Pantalla de Registro
        composable("registro") {
            PantallaRegistro(navController, auth)
        }
        // Pantalla de Lista de Farmacias
        composable("lista") {
            PantallaListaFarmacias(navController)
        }
        // Pantalla del Mapa
        composable("mapa/{latitud}/{longitud}") { backStackEntry ->
            val latitud = backStackEntry.arguments?.getString("latitud")?.toDoubleOrNull() ?: 0.0
            val longitud = backStackEntry.arguments?.getString("longitud")?.toDoubleOrNull() ?: 0.0
            PantallaMapa(latitud, longitud)
        }
    }
}
