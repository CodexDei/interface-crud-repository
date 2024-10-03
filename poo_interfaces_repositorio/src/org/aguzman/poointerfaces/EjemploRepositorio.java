package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;
import org.aguzman.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.RegistroDuplicadoRegistroDatoException;
import org.aguzman.poointerfaces.repositorio.lista.ClientListRepository;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {

            FullRepositorio<Cliente> repo = new ClientListRepository();
            repo.crear(new Cliente("Jano", "Pérez"));
            repo.crear(new Cliente("Bea", "González"));
            repo.crear(new Cliente("Luci", "Martínez"));
            repo.crear(new Cliente("Andrés", "Guzmán"));

            Cliente pedro = new Cliente("Pedro", "Picapiedra");

            repo.crear(pedro);

            //Se usaba para probar funcionamiento excepcion escritura cuando hay un id repetido
            //repo.crear(pedro);
            //Se usaba para probar funcionamiento excepcion de escritura cuando el registro es null
            //repo.crear(null);

            System.out.println("******** LISTAR ***********");
            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("===== paginable =====");
            List<Cliente> paginable = repo.listar(1, 4);
            paginable.forEach(System.out::println);

            System.out.println("===== ordenar =====");
            List<Cliente> clientesOrdenAsc = repo.listar("id", Direccion.DESC);
            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }

            System.out.println("===== editar =====");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(3);
            repo.editar(beaActualizar);
            Cliente bea = repo.porId(3);
            System.out.println(bea);
            System.out.println(" ============= ");
            repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
            System.out.println("===== eliminar ======");
            repo.eliminar(1);
            repo.listar().forEach(System.out::println);
            System.out.println("============== Total =====================");
            System.out.println("Total Registros de la Base de datos: " + repo.total());

        } catch (RegistroDuplicadoRegistroDatoException e) {

            System.err.println("Registro Duplicado: " + e.getMessage());
            e.printStackTrace();

        } catch (LecturaAccesoDatoException e){

            System.err.println("Lectura: " + e.getMessage());
            e.printStackTrace();

        } catch (EscrituraAccesoDatoException e){

            System.err.println("Escritura: " + e.getMessage());
            e.printStackTrace();

        } catch (AccesoDatoException e){

            System.err.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
