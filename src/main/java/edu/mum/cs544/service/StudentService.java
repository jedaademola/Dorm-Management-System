package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.StudentDao;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.RoomApplication;
import edu.mum.cs544.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentService(@Qualifier("studentDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(Student student) {
        StudentDao studentDao = (StudentDao) dao;
        studentDao.save(student);
    }


    @Transactional
    public void roomApplication(RoomApplication roomApplication) {
        StudentDao studentDao = (StudentDao) dao;
        studentDao.roomApplication(roomApplication);
    }

}
