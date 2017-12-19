package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Admin;
import edu.mum.cs544.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AdminDao extends AbstractDao<AbstractModel>{

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Admin admin) {
        getSession().save(admin);
        return;
    }


    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
