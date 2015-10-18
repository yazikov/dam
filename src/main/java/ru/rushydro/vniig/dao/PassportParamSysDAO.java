package ru.rushydro.vniig.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.entry.PassportParamSys;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alyon on 27.09.2015.
 */
@Component
public class PassportParamSysDAO extends AbstractDAO<PassportParamSys> {

    public List<String> getAllRootNodes() {
        TypedQuery<String> query = em.createQuery("SELECT DISTINCT pps.objMonitor FROM PassportParamSys pps WHERE pps.number != '' order by pps.objMonitor ", String.class);

        return query.getResultList();
    }

    public List<PassportParamSys> getSensorByType(Integer type) {
        TypedQuery<PassportParamSys> query = em.createQuery("SELECT pps FROM PassportParamSys pps WHERE pps.measParamTypeSig.id_type = :measParamType ", PassportParamSys.class);
        query.setParameter("measParamType",type);
        return query.getResultList();
    }

    public PassportParamSys getById(Integer id) {
        TypedQuery<PassportParamSys> query = em.createQuery("SELECT pps FROM PassportParamSys pps WHERE pps.idSensors = :id ", PassportParamSys.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public PassportParamSys save(PassportParamSys passportParamSys) {
        try {
            em.getTransaction().begin();
            if (passportParamSys.getIdSensors() == null) {
                em.persist(passportParamSys);
            } else {
                em.merge(passportParamSys);
            }
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passportParamSys;
    }

    public Collection getAvandPreSign() throws SQLException
    {
        return null;
    }

}