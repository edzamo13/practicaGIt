
package ec.com.empresa.dao.impl;
 

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import lombok.Getter;


@PersistenceContexts({
    @PersistenceContext(name = DaoImpl.DEFAULT_PU, unitName = DaoImpl.DEFAULT_PU)
})
public class DaoImpl<T> {

    public static final String DEFAULT_PU = "ap-todo1-kardex-mysql-PU";

    @Resource
    @Getter
    private EJBContext ejbContext;

    private final GenericoDao<T> dao;


    public DaoImpl() {
        dao = new GenericoDao();
    }


    public DaoImpl(Class<T> entidad) {
        dao = new GenericoDao();
        dao.setEntity(entidad);
    }


    public GenericoDao<T> getDao() {

        EntityManager em = (EntityManager) ejbContext.lookup(DEFAULT_PU);
        dao.setEntityManager(em);
        return dao;
    }

    public GenericoDao<T> getDao(String unidadPersistencia) {
        EntityManager em = (EntityManager) ejbContext.lookup(unidadPersistencia);
        dao.setEntityManager(em);
        return dao;
    }

}
