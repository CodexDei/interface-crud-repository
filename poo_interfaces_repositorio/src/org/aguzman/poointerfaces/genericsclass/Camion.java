package org.aguzman.poointerfaces.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{
    //Atributos de las clase
    private List<T> objetos;
    private int max;
    //Constructores de la clase
    public Camion(int max){

        this.max = max;
        objetos = new ArrayList<>();
    }
    //metodo add de la clase
    public void addCamion(T objeto){

        if (this.objetos.size() <= max){

            this.objetos.add(objeto);

        }else {

            throw new RuntimeException("ERROR. La lista esta llena, no hay mas espacio");
        }
    }
    @Override
    public Iterator<T> iterator() {
        
        return this.objetos.iterator();
    }
}
