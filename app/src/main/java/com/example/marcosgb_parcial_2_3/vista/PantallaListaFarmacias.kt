package com.example.marcosgb_parcial_2_3.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.marcosgb_parcial_2_3.R
import com.example.marcosgb_parcial_2_3.modelo.Farmacia
import com.example.marcosgb_parcial_2_3.modelo.VistaModeloFarmacia

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaListaFarmacias(
    navController: NavController,
    vistaModeloFarmacia: VistaModeloFarmacia = viewModel()
) {
    val farmacias = vistaModeloFarmacia.obtenerFarmacias().observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Farmacias Zaragoza") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(farmacias.value) { farmacia ->
                ItemFarmacia(farmacia) {
                    // Navegar a la pantalla del mapa con las coordenadas
                    navController.navigate("mapa/${farmacia.latitud}/${farmacia.longitud}")
                }
            }
        }
    }
}

@Composable
fun ItemFarmacia(farmacia: Farmacia, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(farmacia.nombre, style = MaterialTheme.typography.titleMedium)
                Text(farmacia.telefono, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_farmacia), // Agrega un ícono en `res/drawable`
                contentDescription = "Ícono de Farmacia",
                modifier = Modifier.size(40.dp)
            )
        }
    }
}
