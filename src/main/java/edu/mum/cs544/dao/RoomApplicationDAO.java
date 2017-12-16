package edu.mum.cs544.dao;

import edu.mum.cs544.model.RoomApplication;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomApplicationDAO {

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
}
