package org.aguzman.poointerfaces.genericsclass;

public class Animal {
    //Artibutos de la clase
    private String nombre;
    private TipoAnimal tipo;
    //constructor
    public Animal(String nombre, TipoAnimal tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    //getters
    public String getNombre() {
        return nombre;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }
}
