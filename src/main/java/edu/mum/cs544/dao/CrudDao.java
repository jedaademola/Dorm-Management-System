package edu.mum.cs544.dao;

import edu.mum.cs544.model.AbstractModel;
import edu.mum.cs544.util.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.sql.DataSource;

@Repository
public class CrudDao extends AbstractDao<AbstractModel> {

    private final static Logger logger = LoggerFactory.getLogger(CrudDao.class);

  //  private final EntityManager em = JPAUtil.getEntityManager();
/*
    @Transactional
    public void addTvSeries(TvSeries p) {

        EntityTransaction tx = null;

        try {

            tx = em.getTransaction();
            tx.begin();
            em.persist(p);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) {
                logger.error("[addTvSeries] Rolling back:", e);
                tx.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
*/
    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
