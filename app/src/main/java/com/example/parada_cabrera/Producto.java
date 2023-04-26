package com.example.parada_cabrera;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.PropertyName;

import org.checkerframework.checker.optional.qual.Present;

import java.io.Serializable;



public class Producto implements Serializable {
    private String id;
    private String nombre;
    private Double precio;
    private String urlImagen;

    @Exclude
    public String getId() {
        return id;
    }
    @Exclude
    public void setId(String id) {
        this.id = id;
    }

    public Producto(){}

    public Producto(String nombre, Double precio, String urlImagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @PropertyName("url_imagen")

    public String getUrlImagen() {
        return urlImagen;
    }

    @PropertyName("url_imagen")


    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
