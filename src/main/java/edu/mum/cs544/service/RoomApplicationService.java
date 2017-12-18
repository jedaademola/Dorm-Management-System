package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.RoomApplicationDAO;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.RoomApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class RoomApplicationService extends AbstractService<AbstractModel>{

    private final static Logger logger = LoggerFactory.getLogger(RoomApplicationService.class);

    @Autowired
    public RoomApplicationService(@Qualifier("roomApplicationDAO") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(RoomApplication roomApplication){
        RoomApplicationDAO roomApplicationDAO = (RoomApplicationDAO) dao;
        roomApplicationDAO.saveApplication(roomApplication);
    }

    @Transactional
    public List<RoomApplication> roomApplications(){
        RoomApplicationDAO roomApplicationDAO = (RoomApplicationDAO) dao;
        return roomApplicationDAO.applicationList();

    }

    @Transactional
    public void delete(RoomApplication roomApplication){
        RoomApplicationDAO roomApplicationDAO = (RoomApplicationDAO) dao;
        roomApplicationDAO.delete(roomApplication);
    }

    @Transactional
    public void update(RoomApplication roomApplication){
        RoomApplicationDAO roomApplicationDAO = (RoomApplicationDAO) dao;
        roomApplicationDAO.update(roomApplication);
    }

    @Transactional
    public List<RoomApplication> byStudentId(long id){
        RoomApplicationDAO roomApplicationDAO = (RoomApplicationDAO) dao;
        return (List<RoomApplication>) roomApplicationDAO.findByStudentId(id);
    }
}
