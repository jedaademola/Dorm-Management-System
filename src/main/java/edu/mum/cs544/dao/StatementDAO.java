package edu.mum.cs544.dao;

import edu.mum.cs544.model.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StatementDAO {

    private SessionFactory _sessionFactory;
    private Session getSession() {

        return _sessionFactory.getCurrentSession();
    }

    public void saveStatement(Statement statement){
        getSession().save(statement);

    }

    public List<Statement> applicationList(){

        return getSession().createQuery("from Statement where s.category = category").list();
    }

    public void update(Statement statement) {
        getSession().update(statement);
    }
}
