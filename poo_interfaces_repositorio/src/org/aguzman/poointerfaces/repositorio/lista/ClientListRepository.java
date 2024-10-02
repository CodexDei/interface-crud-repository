package org.aguzman.poointerfaces.repositorio.lista;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.AbstractListRepository;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ClientListRepository extends AbstractListRepository<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo, a, b);
            } else if(dir == Direccion.DESC){
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
            case "edad" ->
                resultado = a.getEdad().compareTo(b.getEdad());
        }
        return resultado;
    }

}
