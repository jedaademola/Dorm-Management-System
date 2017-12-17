package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class StudentDao extends AbstractDao<AbstractModel> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Student Student) {
        getSession().save(Student);
        return;
    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
