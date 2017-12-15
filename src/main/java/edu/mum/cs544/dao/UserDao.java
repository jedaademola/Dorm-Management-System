package edu.mum.cs544.dao;


import edu.mum.cs544.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Users user) {
        getSession().save(user);
        return;
    }

    public void delete(Users user) {
        getSession().delete(user);
        return;
    }


    public List<Users> getAll() {
        return getSession().createQuery("from Users").list();
    }

    public Users getByEmail(String email) {
        return (Users) getSession().createQuery("from Users where email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }

    public Users getById(long id) {
        return getSession().load(Users.class, id);
    }

    public void update(Users user) {
        getSession().update(user);
        return;
    }
}
