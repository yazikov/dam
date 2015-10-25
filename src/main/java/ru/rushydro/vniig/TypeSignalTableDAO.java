package ru.rushydro.vniig;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.dao.AbstractDAO;
import ru.rushydro.vniig.entry.TypeSignalTable;

import javax.persistence.TypedQuery;

/**
 * Created by alyon on 18.10.2015.
 */
@Component
public class TypeSignalTableDAO extends AbstractDAO<TypeSignalTable> {

    public TypeSignalTable getById(Integer id) {

        TypedQuery<TypeSignalTable> query = em.createQuery("SELECT mps FROM TypeSignalTable mps WHERE mps.idSignal = :id ", TypeSignalTable.class);
        query.setParameter("id", id);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
