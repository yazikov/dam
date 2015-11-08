package ru.rushydro.vniig.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.dao.PassportParamSysDAO;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.entry.SignSys;
import ru.rushydro.vniig.model.Page;
import ru.rushydro.vniig.storage.entry.PassportParamSysStorage;
import ru.rushydro.vniig.storage.entry.SignSysStorage;

import javax.persistence.TypedQuery;
import java.util.Date;

/**
 * Created by alyon on 18.10.2015.
 */
@Component
public class SignSysStorageDAO extends AbstractStorageDAO<SignSysStorage>{

    @Autowired
    PassportParamSysDAO passportParamSysDAO;

    @Autowired
    TypeSignalTblStorageDAO typeSignalTableDao;

    public SignSysStorage getById(Integer id) {
        TypedQuery<SignSysStorage> query = em.createQuery("SELECT mps FROM SignSysStorage mps WHERE mps.passportParamSys.idSensors = :id order by mps.idSign desc ", SignSysStorage.class);
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

    public void insertValues(Integer id, Double value)
    {
        PassportParamSys sensor = passportParamSysDAO.getById(id);
        Float ustavkaPre = sensor.getMeasParamTypeSig().getValueUstavkaPre();
        Float ustavkaAv = sensor.getMeasParamTypeSig().getValueUstavkaAv();
        int val = 1;
        if(value<ustavkaPre)
            val = 1;
        else if(value>ustavkaPre&&value<ustavkaAv)
            val = 2;
        else if(value>ustavkaAv)
            val = 3;

        int rowCount = getJdbcTemplate().update("insert into SIGN_SYS(sort_sign, id_sensors, date_sign, time_sign) VALUES(?,?,CURRENT_DATE,CURRENT_TIME)", val, id);

//        return getById(id);
    }

    public Page<SignSysStorage> filter(Long page, Integer pageSize) {
        TypedQuery<SignSysStorage> query = em.createQuery("SELECT sss FROM SignSysStorage sss ", SignSysStorage.class);
        query.setFirstResult((page.intValue() - 1) * pageSize);
        query.setMaxResults(pageSize);

        TypedQuery<Long> countQuery = em.createQuery("SELECT count(sss) FROM SignSysStorage sss ", Long.class);

        return new Page<>(page, pageSize, countQuery.getSingleResult(), query.getResultList());

    }


//    public boolean kventSensor(Integer id) {
//        SignSys signSys = getById(id);
//        signSys.setTimeKvint(new Date());
//        signSys.setDateKvint(new Date());
//        return true;
//    }
}
