package com.example.marcosgb_parcial_2_3.modelo;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class VistaModeloFarmacia extends AndroidViewModel {
    private final RepositorioFarmacia repositorio;
    private final LiveData<List<Farmacia>> farmacias;

    public VistaModeloFarmacia(@NonNull Application application) {
        super(application);
        repositorio = new RepositorioFarmacia(application);
        farmacias = repositorio.obtenerFarmacias();
    }

    public LiveData<List<Farmacia>> obtenerFarmacias() {
        return farmacias;
    }

    public void cargarFarmaciasDesdeJSON(String json) {
        repositorio.cargarFarmaciasDesdeJSON(json);
    }
}
