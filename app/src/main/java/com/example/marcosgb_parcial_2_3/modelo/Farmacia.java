package com.example.marcosgb_parcial_2_3.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Farmacia implements Parcelable {
    private String nombre;      // Nombre de la farmacia
    private String telefono;    // Teléfono de contacto
    private double latitud;     // Coordenada de latitud
    private double longitud;    // Coordenada de longitud
    private String direccion;   // Dirección completa
    private String horario;     // Horarios de atención

    public Farmacia() {
        // Constructor vacío para Firebase
    }

    public Farmacia(String nombre, String telefono, double latitud, double longitud, String direccion, String horario) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.horario = horario;
    }

    protected Farmacia(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        latitud = in.readDouble();
        longitud = in.readDouble();
        direccion = in.readString();
        horario = in.readString();
    }

    public static final Creator<Farmacia> CREATOR = new Creator<Farmacia>() {
        @Override
        public Farmacia createFromParcel(Parcel in) {
            return new Farmacia(in);
        }

        @Override
        public Farmacia[] newArray(int size) {
            return new Farmacia[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeDouble(latitud);
        dest.writeDouble(longitud);
        dest.writeString(direccion);
        dest.writeString(horario);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
