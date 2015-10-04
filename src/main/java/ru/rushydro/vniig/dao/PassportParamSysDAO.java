package ru.rushydro.vniig.dao;

import org.springframework.stereotype.Component;
import ru.rushydro.vniig.entry.PassportParamSys;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alyon on 27.09.2015.
 */
@Component
public class PassportParamSysDAO extends AbstractDAO<PassportParamSys> {

    public List<String> getAllRootNodes() {
        TypedQuery<String> query = em.createQuery("SELECT DISTINCT pps.objMonitor FROM PassportParamSys pps WHERE pps.number != '' ", String.class);

        return query.getResultList();
    }

    public List<PassportParamSys> getSensorByRootName(String name) {
        TypedQuery<PassportParamSys> query = em.createQuery("SELECT pps FROM PassportParamSys pps WHERE pps.number != '' ", PassportParamSys.class);

        return query.getResultList();
    }

    public Collection getAvandPreSign() throws SQLException
    {
        return null;
    }

}