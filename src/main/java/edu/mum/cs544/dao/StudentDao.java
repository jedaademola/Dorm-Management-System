package edu.mum.cs544.dao;

import edu.mum.cs544.model.*;
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

    public Student getStudentById(String studentId) {

        return (Student) getSession().createQuery("from Student where studentId = :studentId")
                .setParameter("studentId", studentId)
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


    public Room getRoomById(String roomNo,long buildingId) {

        return (Room) getSession().createQuery("from Room where roomNo = :roomNo and buildingId =:buildingId")
                .setParameter("roomNo", roomNo)
                .setParameter("buildingId", buildingId)
                .uniqueResult();
    }
    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
