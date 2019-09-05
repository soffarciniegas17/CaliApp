package com.caliatumano.models;

public class Categoria {

    private String id;
    private String nombre;
    private int image;


    public Categoria(String id, String nombre, int image) {
        this.id = id;
        this.nombre = nombre;
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
