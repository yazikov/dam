package ru.rushydro.vniig.dao;

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
public class PassportParamSysDAO extends AbstractDAO<PassportParamSys> {
    public List<String> getAllRootNodes() throws SQLException
    {
        EntityTransaction tx = null;
        List<String> result;
        try{
            tx = em.getTransaction();
            tx.begin();
            TypedQuery<String> query = em.createNamedQuery("SELECT DISTINCT obj_monitor FROM" + PassportParamSys.getTableName() + "WHERE number_of_sensor!='';", String.class);
            result = query.getResultList();
            tx.commit();
        }
        catch(RuntimeException e) {
            if ( tx != null && tx.isActive() ) tx.rollback();
            throw e;
        }
        return result;
    }
    public Collection getChildCollectionByRootName(String name)throws SQLException
    {
        EntityTransaction tx = null;
        List<String> result;
        try{
            tx = em.getTransaction();
            tx.begin();
            TypedQuery<String> query = em.createNamedQuery("SELECT DISTINCT pps.obj_monitor FROM PassportParamSys pps WHERE number_of_sensor!='';", String.class);
            result = query.getResultList();
            tx.commit();
        }
        catch(RuntimeException e) {
            if ( tx != null && tx.isActive() ) tx.rollback();
            throw e;
        }
        return result;

        return null;
    }
    public Collection getAvandPreSign() throws SQLException
    {
        return null;
    }

}