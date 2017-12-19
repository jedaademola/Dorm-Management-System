package edu.mum.cs544.service;


import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.AdminDao;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    public AdminService(@Qualifier("adminDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(Admin admin) {
        AdminDao adminDao= (AdminDao) dao;
     adminDao.save(admin);
            }
}
