package com.appalber.rutesmapsgeo;

import java.util.List;

public class Rutas {

    private String nombre;
    private List<Ubicacion> lista_coordenadas;

    public Rutas() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ubicacion> getLista_coordenadas() {
        return lista_coordenadas;
    }

    public void setLista_coordenadas(List<Ubicacion> lista_coordenadas) {
        this.lista_coordenadas = lista_coordenadas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
