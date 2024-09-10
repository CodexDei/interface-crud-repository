package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Producto;
import org.aguzman.poointerfaces.modelo.Producto;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.FullRepositorio;
import org.aguzman.poointerfaces.repositorio.lista.ClientListRepository;
import org.aguzman.poointerfaces.repositorio.lista.ProductListRepository;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        FullRepositorio<Producto> repo = new ProductListRepository();
        repo.crear(new Producto("Bloqueador_solar", 20000.0));
        repo.crear(new Producto("Crema_Arrugas", 15000.0));
        repo.crear(new Producto("Crema_Hidratante", 12000.0));
        repo.crear(new Producto("Sabila", 5000.0));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("===== paginable =====");
        List<Producto> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenar =====");
        List<Producto> productosOrdenAsc = repo.listar("apellido", Direccion.ASC);
        for(Producto c: productosOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Producto sabilaActualizar = new Producto("Colageno", 35000.0);
        sabilaActualizar.setId(2);
        repo.editar(sabilaActualizar);
        Producto sabila = repo.porId(2);
        System.out.println(sabila);
        System.out.println(" ============= ");
        repo.listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("===== eliminar ======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("============== Total =====================");
        System.out.println("Total Registros de la Base de datos: " + repo.total());
    }
}
