package org.aguzman.poointerfaces.generics;

import org.aguzman.poointerfaces.modelo.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EjemploGenericos {

    public static void main(String[] args) {

        List<Cliente> cliente = new ArrayList<>();
        cliente.add(new Cliente("Jose", "Perez"));

        Cliente jose = cliente.iterator().next();

        //Arreglo clientes
        Cliente[] clienteArreglo = {new Cliente("Pepe","Ganga"),
                                    new Cliente("Luz", "Max")};
        //Arreglo Enteros
        Integer[] numerosArreglo = {1,2,3,4,5,6,7};
        //Arreglo String
        String[] frutasArreglo = {"manzana", "pera","banano"};
        //Se crea la lista y de una vez se usa el metodo deArregloALista y
        //dentro de dicho metodo se crea el arreglo con sus elementos
        //Usa la sobrecarga de public static <T extends Cliente & Comparable<T>
        //Porque es la mas cercana al tipo de Lista
        List<Cliente> clientePremiumLista = deArregloALista(
                new ClientePremium[]{new ClientePremium("Pedro","Apostol"),
                new ClientePremium("Juan","Angel")});
        System.out.println("*******Usando sobrecarga <T exteds Cliente*******");
        imprimirClientes(clientePremiumLista);
        //creamos y declaramos la lista deTodo
        List<Object> deTodo = new ArrayList<>();
        //Agregamos los arreglos con AddAll para que permita agregar cualquier elemento
        //Usamos el metodo que creamos:deArregloALista para agregarlo a la lista deTodo
        deTodo.addAll(deArregloALista(clienteArreglo));
        //usando metodos genericos acotados o Bounded TYpes
        //la siguiente linea usaria <T extends Number>
        //Al colocar el cursor en "deArreglo..."mostrara que metodo sobrecargado esta usando
        deTodo.addAll(deArregloALista(numerosArreglo));
        deTodo.addAll(deArregloALista(frutasArreglo));
        //Imprimir lista
        imprimiLista(deTodo);
        //uso de la sobrecarga del metodo deArregloALista
        System.out.println("*********Usando deArregloALista sobrecargado*********");
        List<Cliente> clientesLista = new ArrayList<>();
        //No usa deArregloLista porque si bien es tipo Cliente
        //no implementa la interfaz Comprable<T>
        //por ello Usa el metodo mas generico <T> List<T>deArregloALista
        clientesLista = deArregloALista(clienteArreglo);
        System.out.println("*******IMPRIMIENDO ClienteLista**************");
        imprimirClientes(clientesLista);
        //uso del metodo generico listaCombinada
        System.out.println("****************Lista combinada usando metodo combinarLista**********");
        List<Object> listaCombinada = new ArrayList<>();
        listaCombinada.add(combinarListas(cliente,deTodo,clientesLista));
        imprimiLista(listaCombinada);
        //Hallar el valor maximo
        System.out.println("*****VALOR MAXIMO********");
        Cliente luis = new Cliente("Luis", "Castillo",35,7000000.0);
        Cliente maye = new Cliente("Marye", "Mora",35,10000000.0);
        Cliente samy = new Cliente("Samy", "Acosta",35,30000000.0);
        maximoCliente(luis,maye,samy);

    }
    //Transforma un arreglo es una lista generica
    public static <T> List<T>deArregloALista(T[] arreglo){

        return Arrays.asList(arreglo);
    }
    //metodo deArregloALista acotado o Bounded Types
    //EL "& Comparable<T> indica que debe implementar tambien esta interfaz para poder
    //usar este metodo

//    public static <T extends Cliente & Comparable<T>> List<T>deArregloALista(T[] cliente){
//
//        return Arrays.asList(cliente);
//    }

    public static <T extends Number> List<T>deArregloALista(T[] arreglo){

        return Arrays.asList(arreglo);
    }

    public static <T,G> List<T>deArregloALista(T[] arreglo1, G[] arreglo2){

        for (G elemento : arreglo2){

            System.out.println(elemento);

        }

        return Arrays.asList(arreglo1);
    }
    //Es un metodo generico que combina # cantidad de listas y retorna una sola
    public static List<Object> combinarListas(List<?>...listas){

        List<Object> listaCombinada = new ArrayList<>();

        for (List<?> elemento : listas){

            listaCombinada.addAll(elemento);
        }

        return listaCombinada;
    }
    //Metodo para imprimir cualquier objeto Cliente y sus clases hijas o subclases
    public static void imprimirClientes(List<? extends Cliente> cliente){

        cliente.forEach(System.out::println);
    }
    //metodo que imprime cualquier lista
    public static void imprimiLista(List<?> lista){

        lista.forEach(System.out::println);
    }
    //Metodo que retorna el valor Maximo
    public static <T extends Comparable<T>> T maximo(T a, T b, T c){

        T max = a;

        if (b.compareTo(max) > 0){

            max = b;
        }
        if (c.compareTo(max) > 0){

            max = c;
        }

        return max;
    }
    //Muestra los o el cliente con la mayor edad
    public static <T extends Cliente> void maximoCliente(T a, T b, T c) {
        // Identificar el máximo de edad
        T maxEdad = a;
        boolean aEsMax = true, bEsMax = false, cEsMax = false;

        if (b.compareTo(maxEdad.getEdad()) > 0) {
            maxEdad = b;
            aEsMax = false;
            bEsMax = true;
        } else if (b.compareTo(maxEdad.getEdad()) == 0) {
            bEsMax = true;
        }

        if (c.compareTo(maxEdad.getEdad()) > 0) {
            maxEdad = c;
            aEsMax = false;
            bEsMax = false;
            cEsMax = true;
        } else if (c.compareTo(maxEdad.getEdad()) == 0) {
            cEsMax = true;
        }

        // Verificar si todos tienen la misma edad
        if (aEsMax && bEsMax && cEsMax) {
            System.out.println("Los clientes:\n" +
                    "* " + a.getNombre() + " " + a.getApellido() + "\n" +
                    "* " + b.getNombre() + " " + b.getApellido() + "\n" +
                    "* " + c.getNombre() + " " + c.getApellido() + "\n" +
                    "\nTienen la misma edad de " + maxEdad.getEdad() + " años.");
        } else {
            System.out.println("El/Los cliente(s) con la mayor edad de " + maxEdad.getEdad() + " años es/son:");
            if (aEsMax) {
                System.out.println("- " + a.getNombre() + " " + a.getApellido());
            }
            if (bEsMax) {
                System.out.println("- " + b.getNombre()+ " " + b.getApellido());
            }
            if (cEsMax) {
                System.out.println("- " + c.getNombre() + " " + c.getApellido());
            }
        }
    }
}

