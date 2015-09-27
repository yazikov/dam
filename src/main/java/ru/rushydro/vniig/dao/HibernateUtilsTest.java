package ru.rushydro.vniig.dao;

import junit.framework.TestCase;
import ru.rushydro.vniig.entry.MeasParamSys;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 * Created by alyon on 27.09.2015.
 */

public class HibernateUtilsTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private void clearData() {
        EntityManager em = HibernateUtil.getEjb3Configuration()
                .buildEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery(new StringBuilder("delete from ").append(
                MeasParamSys.class.getName()).toString());
        query.executeUpdate();
        tx.commit();
        em.close();
    }

    public void testInsertData() {
        clearData();

        EntityManager em = HibernateUtil.getEjb3Configuration()
                .buildEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Long id_500 = null;
        for (int i = 0; i < 1000; i++) {
//            MeasParamSys newMeasParamSys = new MeasParamSys();
//            MeasParamSys.setFirstName(new StringBuilder("FName_").append(i)
//                    .toString());
//            newContact.setLastName(new StringBuilder("LName_").append(i)
//                    .toString());
//            em.persist(newContact);
//            if (i == 500) {
//                id_500 = newContact.getContactId();
//            }
        }
        em.getTransaction().commit();

        em.getTransaction().begin();
//        Contact testContact = em.find(Contact.class, id_500);
//        assertEquals("FName_500", testContact.getFirstName());
//        assertEquals("LName_500", testContact.getLastName());
        em.getTransaction().commit();

        em.close();
    }
}
