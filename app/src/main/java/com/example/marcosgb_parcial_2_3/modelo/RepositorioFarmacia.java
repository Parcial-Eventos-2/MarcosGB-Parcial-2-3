package com.example.marcosgb_parcial_2_3.modelo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFarmacia {
    private final MutableLiveData<List<Farmacia>> farmacias;
    private final Application application;

    public RepositorioFarmacia(Application application) {
        this.application = application;
        this.farmacias = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<Farmacia>> obtenerFarmacias() {
        return farmacias;
    }

    public void cargarFarmaciasDesdeJSON(String json) {
        // Usa Gson para convertir el JSON a objetos Farmacia
        Gson gson = new Gson();
        Type tipoListaFarmacias = new TypeToken<List<Farmacia>>() {}.getType();
        List<Farmacia> listaFarmacias = gson.fromJson(json, tipoListaFarmacias);
        farmacias.postValue(listaFarmacias);
    }

    // Opcional: Métodos para interactuar con Firebase si deseas usarlo como backend.
}

