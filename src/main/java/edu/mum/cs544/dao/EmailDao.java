package edu.mum.cs544.dao;



import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.EmailDetails;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;



@Repository
public class EmailDao extends AbstractDao<AbstractModel> {

//String sender, String recipient, String subject, String contentType, String content,

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }
    public void queueMessage(EmailDetails email) {

        getSession().save(email);
        return;
    }

    public int updateEmailStatus(long id, int status) {

        Query query = getSession().createQuery("update EmailDetails set status = :status" +
                " where id = :id");
        query.setParameter("status", status);
        query.setParameter("id", id);
        int result = query.executeUpdate();

        return result;


    }

    public List<EmailDetails> getEmailsToSend() {

        return getSession().createQuery("from EmailDetails where status = 0 ").list();


    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
