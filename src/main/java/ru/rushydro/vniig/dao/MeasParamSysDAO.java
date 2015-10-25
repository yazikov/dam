package ru.rushydro.vniig.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.entry.Insision;

import javax.persistence.TypedQuery;

/**
 * Created by nikolay on 11.10.15.
 */
@Component
public class MeasParamSysDAO extends AbstractDAO<Insision.MeasParamSys> {

    public Insision.MeasParamSys getById(Integer id) {
        TypedQuery<Insision.MeasParamSys> query = em.createQuery("SELECT mps FROM MeasParamSys mps WHERE mps.idSensors = :id ", Insision.MeasParamSys.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public Insision.MeasParamSys save(Insision.MeasParamSys measParamSys) {
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

    public Insision.MeasParamSys updateValue (Integer id, Double value) {
        Insision.MeasParamSys measParamSys = getById(id);
        measParamSys.setValueMeas(value.floatValue());
        return save(measParamSys);
    }

}
