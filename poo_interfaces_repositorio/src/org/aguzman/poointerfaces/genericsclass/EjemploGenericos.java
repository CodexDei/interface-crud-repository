package org.aguzman.poointerfaces.genericsclass;

import static org.aguzman.poointerfaces.genericsclass.TipoAnimal.*;

public class EjemploGenericos {

    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addCamion(new Animal("Rayo", CABALLO));
        transporteCaballos.addCamion(new Animal("Turbo",CABALLO));
        transporteCaballos.addCamion(new Animal("Princess",CABALLO));
        transporteCaballos.addCamion(new Animal("Maravilla",CABALLO));
        transporteCaballos.addCamion(new Animal("Cucaracha",CABALLO));

        Camion<Maquinaria> transporteMaquinaria = new Camion(3);
        transporteMaquinaria.addCamion(new Maquinaria("Bulldozer"));
        transporteMaquinaria.addCamion(new Maquinaria("Grua Horquilla"));
        transporteMaquinaria.addCamion(new Maquinaria("Perforadora"));

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.addCamion(new Automovil("Toyota"));
        transAuto.addCamion(new Automovil("Lamborgini"));
        transAuto.addCamion(new Automovil("Ferrari"));

        System.out.println("USANDO METODO GENERICO");
        imprimirCamion(transporteCaballos);
        imprimirCamion(transporteMaquinaria);
        imprimirCamion(transAuto);
    }

    public static <T> void imprimirCamion(Camion<T> elemento){

        for (T e : elemento){


            if (e instanceof Animal){

                System.out.println("Nombre: " + ((Animal) e).getNombre() +
                        "  Animal: " + ((Animal) e).getTipo());
            }

            else if (e instanceof Maquinaria){

                System.out.println("Maquinaria: " + ((Maquinaria) e).getTipo());

            }
            else if (e instanceof Automovil){

                System.out.println("Auto: " + ((Automovil) e).getMarca());

            }
        }
    }
}
