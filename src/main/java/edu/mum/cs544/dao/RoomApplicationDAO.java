package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.RoomApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
@Repository
@Transactional
public class RoomApplicationDAO extends AbstractDao<AbstractModel>{


    @Autowired
    private SessionFactory _sessionFactory;



    private Session getSession() {

        return _sessionFactory.getCurrentSession();
    }

    public void saveApplication(RoomApplication roomApplication){
        getSession().save(roomApplication);

    }

    public List<RoomApplication> applicationList(){

        return getSession().createQuery("from RoomApplication").list();
    }

    public void delete(RoomApplication roomApplication) {
        getSession().delete(roomApplication);

    }
    public void update(RoomApplication roomApplication) {
        getSession().update(roomApplication);
    }

   public List<RoomApplication> findByStudentId(long id){
        return getSession().createQuery("from RoomApplication s where s.studentId =:studentId").list();
   }
//
//   public void setStatus(long id){
//        getSession().
//   }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
