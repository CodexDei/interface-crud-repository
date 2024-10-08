package org.codexdei.poointerfaces.modelo;

import java.util.Objects;

public class Cliente {
    //Atributos de la clase
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId = 0;
    //Constructores
    //Constructor vacio
    public Cliente(){
        this.id = ++ultimoId;
    }
    //Constructor con parametros
    public Cliente(String nombre, String apellido){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }
    //getters and setters
    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //equals


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toString
    @Override
    public String toString(){
        return "Id=" + this.id + "\t" +
                "Nombre=" + this.nombre + "\t" +
                "Apellido=" + this.apellido;
    }
}
