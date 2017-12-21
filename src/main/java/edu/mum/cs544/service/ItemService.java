package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.ItemDAO;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService extends AbstractService<AbstractModel>{

    private final static Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    public ItemService(@Qualifier("itemDAO") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

//    @Transactional
//    public void save(Item item) {
//        ItemDAO itemDAO = (ItemDAO) dao;
//        itemDAO.add(item);
//    }
//
//    @Transactional
//    public void delete(Item item){
//        ItemDAO itemDAO = (ItemDAO) dao;
//        itemDAO.delete(item);
//
//    }

    @Transactional
    public List<Item> itemList(){
        ItemDAO itemDAO = (ItemDAO) dao;
        return itemDAO.getAll();
    }
}
