package org.codexdei.poointerfaces.repositorio;

import org.codexdei.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRepositorio{
    //Atributos de la clase
    private List<Cliente> dataSource;
    //Constructores
    public ClienteListRepositorio(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente buscarId(Integer id) {

        Cliente resultado = null;

        for (Cliente cli : dataSource){

            if (cli.getId().equals(id)){
                resultado = cli;
            }
            break;
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {

        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {

        Cliente cli = this.buscarId(cliente.getId());
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());

//        for (Cliente cli: dataSource){
//
//            if (cli.equals(cliente)){
//                this.dataSource.get(cliente.getId()).add(cliente);
//            }
//            break;
//        }
    }

    @Override
    public void eliminar(Integer id) {
        //verificar si funciona????
        this.dataSource.remove(id);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {

        dataSource.sort((a, b) -> {

            int resultado = 0;

            if (dir == Direccion.ASC){

                switch (campo){

                    case "id" ->
                        resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                        resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                        resultado = a.getApellido().compareTo(b.getApellido());
                }

            } else if (dir == Direccion.DESC) {

                switch (campo){

                    case "id" ->
                            resultado = b.getId().compareTo(a.getId());
                    case "nombre" ->
                            resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido" ->
                            resultado = b.getApellido().compareTo(a.getApellido());
                }

            }

            return resultado;
        });

        return dataSource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }
}
