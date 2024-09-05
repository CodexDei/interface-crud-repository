package org.aguzman.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable<Cliente>{


    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public ClientePremium(String nombre, String apellido, Integer edad, Double sueldo) {
        super(nombre, apellido, edad, sueldo);
    }

    @Override
    public int compareTo(Cliente o) {
        return 0;
    }
}
