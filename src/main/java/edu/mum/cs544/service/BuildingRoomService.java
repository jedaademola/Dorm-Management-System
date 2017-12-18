package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.BuildingRoomDao;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Building;
import edu.mum.cs544.model.LabelValue;
import edu.mum.cs544.model.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingRoomService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(BuildingRoomService.class);


    @Autowired
    public BuildingRoomService(@Qualifier("buildingRoomDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }


    @Transactional
    public List<Building> listBuilding() {
        BuildingRoomDao buildingRoomDao = (BuildingRoomDao) dao;
        return buildingRoomDao.listBuilding();
    }

    @Transactional
    public List<Room> listRoom(long buildingId) {

        BuildingRoomDao buildingRoomDao = (BuildingRoomDao) dao;
        return buildingRoomDao.listRoom(buildingId);

    }

    public List<LabelValue> getRoomListForDropDown(int buildingId) {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Room r : listRoom(buildingId)) {

            LabelValue l = new LabelValue();
            l.setLabel(r.getRoomNo());
            l.setValue(r.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public List<LabelValue> getBuildingListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Building b : listBuilding()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getBuildingNo());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

}
