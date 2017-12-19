package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Complain;
import edu.mum.cs544.model.RoomApplication;
import edu.mum.cs544.model.Student;
import org.hibernate.Query;
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

    public Student getStudentById(long id) {

        return (Student) getSession().createQuery("from Student where id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    public void addStudentComplaint(Complain complain) {
        getSession().save(complain);
        return;
    }

    public int addFeedbackComplaint(Complain complain) {

        Query query = getSession().createQuery("update Complain set feedback = :feedback" +
                " where id = :id");
        query.setParameter("feedback", complain.getFeedBack());
        query.setParameter("id", complain.getId());
        int result = query.executeUpdate();

        return result;
    }

    public void roomApplication(RoomApplication roomApplication) {
        getSession().save(roomApplication);
        return;
    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
