package ru.rushydro.vniig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import ru.rushydro.vniig.entry.AbstractEntry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by nikolay on 20.09.15.
 */
@Transactional
public class AbstractDAO<T extends AbstractEntry> {

    @PersistenceContext
    EntityManager em;


    public AbstractDAO() {
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