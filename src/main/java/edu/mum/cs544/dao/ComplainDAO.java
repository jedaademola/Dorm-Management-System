package edu.mum.cs544.dao;

import edu.mum.cs544.model.Complain;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComplainDAO {

    @Autowired
    private SessionFactory _sessionFactory;
    private Session getSession() {

        return _sessionFactory.getCurrentSession();
    }

    public Complain saveComplain(Complain complain){
        getSession().save(complain);
        return complain;
    }

    public List<Complain> listComplain() {
        return getSession().createQuery("from Complain").list();

    }

   // public Complain getById(long id).createQuery("from Complain where studentNo =:studentNo").
}
