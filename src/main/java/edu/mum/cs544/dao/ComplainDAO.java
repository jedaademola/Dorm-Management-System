package edu.mum.cs544.dao;


import edu.mum.cs544.model.Complain;
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


import java.util.List;

@Repository
public class ComplainDAO {

    @Autowired
    private SessionFactory _sessionFactory;
    private Session getSession() {


        return _sessionFactory.getCurrentSession();
    }


    public void save(Complain complain){
        getSession().save(complain);
        //return;

    public Complain saveComplain(Complain complain){
        getSession().save(complain);
        return complain;

    }

    public List<Complain> listComplain() {
        return getSession().createQuery("from Complain").list();

    }


    @Override
    public void setDataSource(DataSource dataSource) {

    }

    public Complain getByStudentId(long id){

        return (Complain) getSession().createQuery("from Complain where studentId =:studentId");

    }

}
