package org.codexdei.poointerfaces.modelo;

public class Cliente {
    //Atributos de la clase
    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId = 1000;
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
    //toString
    @Override
    public String toString(){
        return "Id=" + this.id + "\n" +
                "Nombre=" + this.nombre + "\n" +
                "Apellido=" + this.apellido + "\n";
    }
}
