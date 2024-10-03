package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.BaseEntity;
import org.aguzman.poointerfaces.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepository<T extends BaseEntity> implements FullRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if (id == null || id == 0){

            throw new LecturaAccesoDatoException("El id no puede ser nulo y debe ser mayor a cero");
        }

        T resultado = null;
        for(T t: dataSource){
            if(t.getId() != null && t.getId().equals(id)){
                resultado = t;
                break;
            }
        }

        if (resultado == null){

            throw new LecturaAccesoDatoException("No existe el registro con el id:" + id);
        }

        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {

        if (t == null){

            throw new EscrituraAccesoDatoException("El registro no puede ser nulo");
        }

        if (this.dataSource.contains(t)){

            throw new RegistroDuplicadoRegistroDatoException("El id: '" + t.getId() + "' ya existe en el repositorio");
        }

        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException  {

        if (id == 0 || id == null){

            throw new LecturaAccesoDatoException("No exites el registro con id=" + id);
        }

        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
