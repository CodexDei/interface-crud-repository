package org.codexdei.poointerfaces.repositorio;

import org.codexdei.poointerfaces.modelo.Cliente;
import java.util.List;

public interface CrudRepositorio {

    List<Cliente> listar();
    Cliente buscarId(Integer Id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer id);
}
