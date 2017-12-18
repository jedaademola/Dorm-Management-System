package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class ItemDAO extends AbstractDao<AbstractModel>{

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void add(Item item) {
        getSession().save(item);
        return;
    }

    public void delete(Item item) {
        getSession().delete(item);
        return;
    }

    public List<Item> getAll() {

        return getSession().createQuery("from Item").list();
    }


    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
