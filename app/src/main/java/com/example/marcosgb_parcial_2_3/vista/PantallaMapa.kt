package com.example.marcosgb_parcial_2_3.vista

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun PantallaMapa(latitud: Double, longitud: Double) {
    val posicion = LatLng(latitud, longitud) // Coordenadas de la farmacia
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.builder()
            .target(posicion)
            .zoom(15f)
            .build()
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = com.google.maps.android.compose.MarkerState(position = posicion),
            title = "Ubicación de la Farmacia"
        )
    }
}
