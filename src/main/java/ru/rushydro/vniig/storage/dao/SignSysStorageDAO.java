package ru.rushydro.vniig.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.entry.SignSys;
import ru.rushydro.vniig.storage.entry.SignSysStorage;

import javax.persistence.TypedQuery;
import java.util.Date;

/**
 * Created by alyon on 18.10.2015.
 */
@Component
public class SignSysStorageDAO extends AbstractStorageDAO<SignSysStorage>{


    @Autowired
    TypeSignalTblStorageDAO typeSignalTableDao;

    public SignSys getById(Integer id) {
        TypedQuery<SignSys> query = em.createQuery("SELECT mps FROM SignSys mps WHERE mps.passportParamSys.idSensors = :id ", SignSys.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public SignSys save(SignSys signSys) {
        try {
            em.getTransaction().begin();
            if (signSys.getPassportParamSys().getIdSensors() == null) {
                em.persist(signSys);
            } else {
                em.merge(signSys);
            }
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signSys;
    }

    public SignSys updateValues(Integer id, Double value)
    {
        SignSys signSys = getById(id);
        Float ustavkaPre = signSys.getPassportParamSys().getMeasParamTypeSig().getValueUstavkaPre();
        Float ustavkaAv = signSys.getPassportParamSys().getMeasParamTypeSig().getValueUstavkaAv();
        int val = 1;
        if(value<ustavkaPre)
            val = 1;
        else if(value>ustavkaPre&&value<ustavkaAv)
            val = 2;
        else if(value>ustavkaAv)
            val = 3;

        int rowCount = getJdbcTemplate().update("update SIGN_SYS set sort_sign = ?, date_sign = CURRENT_DATE, time_sign = CURRENT_TIME where id_sensors = ?", val, id);
        System.out.println("Row count: " + rowCount);
        return getById(id);
    }



    public boolean kventSensor(Integer id) {
        SignSys signSys = getById(id);
        signSys.setTimeKvint(new Date());
        signSys.setDateKvint(new Date());
        return true;
    }
}
