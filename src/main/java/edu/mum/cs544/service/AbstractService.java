package edu.mum.cs544.service;


import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.model.AbstractModel;
import org.springframework.transaction.annotation.Transactional;


public abstract class AbstractService<T extends AbstractModel> {


    protected AbstractDao<T> dao;

    public AbstractService(AbstractDao<T> dao) {
        this.dao = dao;
    }

    @Transactional
    public T create(T model) {
        return dao.create(model);
    }

    @Transactional
    public void update(T model) {
        dao.update(model);
    }

    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    public T find(Long id) {
        return dao.find(id);
    }


}
