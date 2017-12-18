package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.ComplainDAO;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Complain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComplainService extends AbstractService<AbstractModel>  {

    private final static Logger logger = LoggerFactory.getLogger(ComplainService.class);



    @Autowired
    public ComplainService(@Qualifier("complainDAO") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(Complain complain) {
       ComplainDAO complainDAO = (ComplainDAO) dao;
        complainDAO.save(complain);
    }

    @Transactional
    public List<Complain> allComplains() {
        ComplainDAO complainDAO = (ComplainDAO) dao;
        return complainDAO.listComplain();
    }

    @Transactional
    public List<Complain> complainByStudentId(int id){
        ComplainDAO complainDAO = (ComplainDAO) dao;
        return complainDAO.getByStudentId(id);
    }

}
