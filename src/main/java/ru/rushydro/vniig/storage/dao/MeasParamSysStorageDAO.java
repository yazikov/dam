package ru.rushydro.vniig.storage.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.entry.MeasParamSys;
import ru.rushydro.vniig.storage.entry.MeasParamSysStorage;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nikolay on 11.10.15.
 */
@Component
public class MeasParamSysStorageDAO extends AbstractStorageDAO<MeasParamSysStorage> {

    public List<MeasParamSysStorage> getById(Integer id) {
        TypedQuery<MeasParamSysStorage> query = em.createQuery("SELECT mps FROM MeasParamSysStorage mps WHERE mps.idSensors = :id ", MeasParamSysStorage.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getResultList();
    }

    public MeasParamSysStorage save(MeasParamSysStorage measParamSys) {
        try {
            em.getTransaction().begin();
            if (measParamSys.getId() == null) {
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

//    public MeasParamSysStorage updateValue (Integer id, Double value) {
//        getJdbcTemplate().update("update meas_param_sys set value_meas = ?, date_meas = CURRENT_DATE, time_meas = CURRENT_TIME where id_sensors = ?", value, id);
//        return getById(id);
//    }

}
