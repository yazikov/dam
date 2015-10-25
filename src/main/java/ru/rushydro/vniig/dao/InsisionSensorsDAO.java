package ru.rushydro.vniig.dao;

import ru.rushydro.vniig.entry.InsisionSensors;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alyon on 25.10.2015.
 */
public class InsisionSensorsDAO  extends AbstractDAO<InsisionSensors> {
    public List<InsisionSensors> getSensorsByIns(Integer ins) {
        TypedQuery<InsisionSensors> query = em.createQuery("SELECT ins FROM InsisionSensors ins WHERE ins.idInsision = :ins", InsisionSensors.class);
        query.setParameter("ins",ins);
        return query.getResultList();
    }
}
