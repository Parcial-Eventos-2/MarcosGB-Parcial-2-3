package com.example.marcosgb_parcial_2_3.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.example.marcosgb_parcial_2_3.modelo.RepositorioFarmacia;

public class SincronizarFarmaciasWorker extends Worker {
    public SincronizarFarmaciasWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Sincronizar datos aquí
        RepositorioFarmacia repositorio = new RepositorioFarmacia((Application) getApplicationContext());
        // Aquí se llamaría a cargarFarmaciasDesdeJSON con un JSON real
        return Result.success();
    }
}
