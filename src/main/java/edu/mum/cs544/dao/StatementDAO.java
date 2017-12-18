package edu.mum.cs544.dao;


import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class StatementDAO extends AbstractDao<AbstractModel> {

    @Autowired
    private SessionFactory _sessionFactory;


    private Session getSession() {

        return _sessionFactory.getCurrentSession();
    }

    public void saveStatement(Statement statement){
        getSession().save(statement);

    }


    public List<Statement> getAll(){

        return getSession().createQuery("from Statement").list();
    }

    public List<Statement> statementByCategory(){
        return getSession().createQuery("from Statement where s.category = category").list();
    }


    @Override
    public void setDataSource(DataSource dataSource) {

    }

    public List<Statement> applicationList(){

        return getSession().createQuery("from Statement where s.category = category").list();
    }

    public void update(Statement statement) {
        getSession().update(statement);
    }

}
