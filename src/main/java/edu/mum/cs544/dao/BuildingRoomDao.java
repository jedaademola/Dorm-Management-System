package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Building;
import edu.mum.cs544.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional

public class BuildingRoomDao extends AbstractDao<AbstractModel> {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void save(Building building) {
        getSession().save(building);
        return;
    }

    public List<Building> listBuilding() {

        List<Building> buildings = new ArrayList<>();
        buildings = getSession().createQuery("from Building").list();
        return buildings;

    }
    public Room getRoomByStudentId(String studentId){
        return (Room) getSession().createQuery("select r from Room r where r.studentId=:studentId");
    }

//    public Building getBuildingByRoom(Room roomNo){
//        return getSession().createQuery("select b from Room b where")
//    }

    public Room getRoomById(int id) {
        return getSession().load(Room.class, id);
    }

    public List<Room> listRoom(int buildingId) {

        return getSession().createQuery("select r from Room r ")  // TODO CHECK THIS
                // return getSession().createQuery("from Room where building =:buildingId or 0 = 0")  // TODO CHECK THIS
                // .setParameter("buildingId", buildingId)
                .list();

    }

    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
