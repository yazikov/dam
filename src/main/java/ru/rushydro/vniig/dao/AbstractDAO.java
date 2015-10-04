package ru.rushydro.vniig.dao;

import ru.rushydro.vniig.entry.AbstractEntry;

import javax.persistence.EntityManager;

/**
 * Created by nikolay on 20.09.15.
 */
public class AbstractDAO<T extends AbstractEntry> {

    EntityManager em;

    public AbstractDAO() {
        em = HibernateUtil.getEjb3Configuration()
                .buildEntityManagerFactory().createEntityManager();
    }

    public boolean delete(T object) {
        try {
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}