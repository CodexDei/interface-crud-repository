package org.codexdei.poointerfaces.repositorio;

import org.codexdei.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);
}
