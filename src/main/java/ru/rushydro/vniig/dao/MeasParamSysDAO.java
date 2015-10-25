package ru.rushydro.vniig.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.entry.Insision;
import ru.rushydro.vniig.entry.MeasParamSys;

import javax.persistence.TypedQuery;

/**
 * Created by nikolay on 11.10.15.
 */
@Component
public class MeasParamSysDAO extends AbstractDAO<MeasParamSys> {

    public MeasParamSys getById(Integer id) {
        TypedQuery<MeasParamSys> query = em.createQuery("SELECT mps FROM MeasParamSys mps WHERE mps.idSensors = :id ", MeasParamSys.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public MeasParamSys save(MeasParamSys measParamSys) {
        try {
            em.getTransaction().begin();
            if (measParamSys.getIdSensors() == null) {
                em.persist(measParamSys);
            } else {
                em.merge(measParamSys);
            }
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return measParamSys;
    }

    public MeasParamSys updateValue (Integer id, Double value) {
        MeasParamSys measParamSys = getById(id);
        measParamSys.setValueMeas(value.floatValue());
        return save(measParamSys);
    }

}
