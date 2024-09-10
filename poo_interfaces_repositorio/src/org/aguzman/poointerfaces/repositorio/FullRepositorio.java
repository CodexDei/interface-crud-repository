package org.aguzman.poointerfaces.repositorio;

//Una interfaz si puede tener herencia multiple de interfaces
public interface FullRepositorio<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>,
                                            PaginableRepositorio<T>, ContableRepositorio{
}
