package edu.mum.cs544.service;


import edu.mum.cs544.dao.AbstractDao;
import edu.mum.cs544.dao.StatementDAO;
import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StatementService extends AbstractService<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(StatementService.class);

    @Autowired
    public StatementService(@Qualifier("statementDAO") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    @Transactional
    public void save(Statement statement){
        StatementDAO statementDAO = (StatementDAO) dao;
        statementDAO.saveStatement(statement);
    }
    @Transactional
    public List<Statement> statementList(){
        StatementDAO statementDAO = (StatementDAO) dao;
        return statementDAO.getAll();
    }
    @Transactional
    public List<Statement> byCategory(){
        StatementDAO statementDAO = (StatementDAO) dao;
        return statementDAO.statementByCategory();
    }
    @Transactional
    public void update(Statement statement){
        StatementDAO statementDAO = (StatementDAO) dao;
        statementDAO.update(statement);
    }


}
