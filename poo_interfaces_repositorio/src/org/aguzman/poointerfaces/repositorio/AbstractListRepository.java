package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.BaseEntity;

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
    public T porId(Integer id) {
        T resultado = null;
        for(T t: dataSource){
            if(t.getId() != null && t.getId().equals(id)){
                resultado = t;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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
