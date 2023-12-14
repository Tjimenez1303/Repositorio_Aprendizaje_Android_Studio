package com.example.a11_recyclerview_ii;

public class Persona {
    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono)
    {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }
}
