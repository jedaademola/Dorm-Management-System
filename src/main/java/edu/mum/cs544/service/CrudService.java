package edu.mum.cs544.service;

import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.CrudDao;
import edu.mum.cs544.model.AbstractModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(CrudService.class);

    @Autowired
    public CrudService(@Qualifier("crudDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }
/*
    @Transactional
    public void addTvSeries(TvSeries series) {

        CrudDao crudDao = (CrudDao) dao;
        crudDao.addTvSeries(series);
    }
*/
}
