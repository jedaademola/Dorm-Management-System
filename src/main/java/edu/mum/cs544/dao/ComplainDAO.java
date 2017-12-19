package edu.mum.cs544.dao;


import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Complain;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class ComplainDAO extends AbstractDao<AbstractModel> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession(){

        return _sessionFactory.getCurrentSession();
    }


    public void save(Complain complain) {
        getSession().save(complain);
    }
/*
    public Complain saveComplain(Complain complain){
        getSession().save(complain);
        return complain;

    }*/

    public List<Complain> listComplainTest() {
        return getSession().createQuery("select c.complainDate,c.subject, c.description,c.id," +
                "c.feedBack,s.fname as name" +
                " from Complain c join Student s " +
                "where c.studentId = s.id").list();

    }

    public List<Complain> listComplain() {
        return getSession().createQuery("select c from Complain c").list();

    }

    public List<Complain> studentComplains(int studentId) {

        Query query = getSession().createQuery("from Complain where studentId = :id ");
        query.setParameter("id", studentId);
        List<Complain> list = query.list();
        return list;

    }



    @Override
    public void setDataSource(DataSource dataSource) {

    }

    public List<Complain> getByStudentId(long id) {

        return getSession().createQuery("from Complain where studentId =:id")
                .setParameter("id", id)
                .list();

    }

}
