package org.aguzman.poointerfaces.modelo;

import java.util.Objects;

public class Cliente extends BaseEntity implements Comparable<Integer>{
    private String nombre;
    private String apellido;
    private Integer edad;
    private Double sueldo;

    public Cliente(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String nombre, String apellido, Integer edad, Double sueldo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sueldo = sueldo;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sueldo=" + sueldo;
    }

    @Override
    public int compareTo(Integer otraEdad) {
        return this.edad.compareTo(otraEdad);
    }
}
