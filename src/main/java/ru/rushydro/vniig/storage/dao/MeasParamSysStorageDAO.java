package ru.rushydro.vniig.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.dao.MeasParamSysDAO;
import ru.rushydro.vniig.entry.MeasParamSys;
import ru.rushydro.vniig.storage.entry.MeasParamSysStorage;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by nikolay on 11.10.15.
 */
@Component
public class MeasParamSysStorageDAO extends AbstractStorageDAO<MeasParamSysStorage> {

    @Autowired
    MeasParamSysDAO measParamSysDAO;

    public List<MeasParamSysStorage> getById(Integer id) {
        TypedQuery<MeasParamSysStorage> query = em.createQuery("SELECT mps FROM MeasParamSysStorage mps WHERE mps.passportParamSys.idSensors = :id ", MeasParamSysStorage.class);
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

    public void insertValue (Integer id, Double value) {
        MeasParamSys measParamSys = measParamSysDAO.getById(id);
        getJdbcTemplate().update("INSERT into meas_param_sys(id_sensors, status_sensors, date_meas, time_meas, value_meas, relative_value_meas, trust_meas, work_sensors) VALUES(?,?,CURRENT_DATE,CURRENT_TIME,?,?,?,?) ",
                id, measParamSys.getStatusSensors() , value, measParamSys.getRelativeValueMeas(), measParamSys.getTrustMeas(), measParamSys.getWorkSensors());

    }

}
