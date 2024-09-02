package org.codexdei.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.codexdei.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        org.aguzman.poointerfaces.repositorio.CrudRepositorio repo = new org.aguzman.poointerfaces.repositorio.ClienteListRepositorio();
        repo.crear(new org.aguzman.poointerfaces.modelo.Cliente("Jano", "Pérez"));
        repo.crear(new org.aguzman.poointerfaces.modelo.Cliente("Bea", "González"));
        repo.crear(new org.aguzman.poointerfaces.modelo.Cliente("Luci", "Martínez"));
        repo.crear(new org.aguzman.poointerfaces.modelo.Cliente("Andrés", "Guzmán"));

        List<org.aguzman.poointerfaces.modelo.Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("===== paginable =====");
        List<org.aguzman.poointerfaces.modelo.Cliente> paginable = ((org.aguzman.poointerfaces.repositorio.PaginableRepositorio)repo).listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenar =====");
        List<org.aguzman.poointerfaces.modelo.Cliente> clientesOrdenAsc = ((org.aguzman.poointerfaces.repositorio.OrdenableRepositorio)repo)
                .listar("apellido", org.aguzman.poointerfaces.repositorio.Direccion.ASC);
        for(org.aguzman.poointerfaces.modelo.Cliente c: clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        org.aguzman.poointerfaces.modelo.Cliente beaActualizar = new org.aguzman.poointerfaces.modelo.Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);
        System.out.println(" ============= ");
        ((org.aguzman.poointerfaces.repositorio.OrdenableRepositorio)repo)
                .listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("===== eliminar ======");
        //repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
