package ru.rushydro.vniig.storage.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.entry.MeasParamTypeSig;

import javax.persistence.TypedQuery;

/**
 * Created by nikolay on 21.02.16.
 */
@Component
public class MeasParamTypeSigStorageDAO extends AbstractStorageDAO<MeasParamTypeSigStorage> {

    public MeasParamTypeSig getById(Integer id) {
        TypedQuery<MeasParamTypeSig> query = em.createQuery("SELECT mps FROM MeasParamTypeSig mps WHERE mps.id_type = :id ", MeasParamTypeSig.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
