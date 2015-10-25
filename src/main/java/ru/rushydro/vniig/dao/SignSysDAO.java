package ru.rushydro.vniig.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.rushydro.vniig.entry.SignSys;

import javax.persistence.TypedQuery;
import java.util.Date;

/**
 * Created by alyon on 18.10.2015.
 */
@Component
public class SignSysDAO extends AbstractDAO<SignSys>{

    @Autowired
    TypeSignalTblDAO typeSignalTableDao;

//    @Transactional
    public SignSys getById(Integer id) {
        TypedQuery<SignSys> query = em.createQuery("SELECT mps FROM SignSys mps WHERE mps.passportParamSys.idSensors = :id ", SignSys.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

//    @Transactional
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

//    @Transactional
    public SignSys updateValues(Integer id, Double value)
    {
        SignSys signSys = getById(id);
        Float ustavkaPre = signSys.getPassportParamSys().getMeasParamTypeSig().getValueUstavkaPre();
        Float ustavkaAv = signSys.getPassportParamSys().getMeasParamTypeSig().getValueUstavkaAv();
        if(value<ustavkaPre)
            signSys.setSortSign(typeSignalTableDao.getById(1));
        else if(value>ustavkaPre&&value<ustavkaAv)
            signSys.setSortSign(typeSignalTableDao.getById(2));
        else if(value>ustavkaAv)
            signSys.setSortSign(typeSignalTableDao.getById(3));
        signSys.setDateSign(new Date());
        signSys.setTimeSign(new Date());
        return save(signSys);
    }
}
