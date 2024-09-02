package org.aguzman.poointerfaces.repositorio;

//Una interfaz si puede tener herencia multiple de interfaces
public interface FullRepositorio extends CrudRepositorio, OrdenableRepositorio,
                                            PaginableRepositorio, ContableRepositorio{
}
