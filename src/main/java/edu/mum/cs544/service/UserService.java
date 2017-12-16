package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.UserDao;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(CrudService.class);

    @Autowired
    public UserService(@Qualifier("userDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(Users user) {
        UserDao userDao = (UserDao) dao;
        userDao.save(user);
    }


}
