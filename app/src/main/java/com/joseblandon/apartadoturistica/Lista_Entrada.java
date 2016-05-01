package com.joseblandon.apartadoturistica;

/**
 * Created by jose on 30/04/2016.
 */
public class Lista_Entrada {
    private int idImagen;
    private String nombre;
    private String nombrePila;
    private String fecha;

    public Lista_Entrada(int idImagen, String nombre, String nombrePila, String fecha) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.nombrePila = nombrePila;
        this.fecha = fecha;
    }

    public int getIdImagen() {
        return idImagen;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNombrePila() {
        return nombrePila;
    }
    public String getFecha() {
        return fecha;
    }
}



