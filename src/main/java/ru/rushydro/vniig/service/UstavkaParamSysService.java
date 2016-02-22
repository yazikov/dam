package ru.rushydro.vniig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.dao.UstavkaParamSysDAO;
import ru.rushydro.vniig.entry.UstavkaParamSys;

/**
 * Created by yazik on 22.02.2016.
 */
@Service
public class UstavkaParamSysService extends AbstractService<UstavkaParamSys, UstavkaParamSysDAO> {

    @Autowired
    public UstavkaParamSysService(UstavkaParamSysDAO dao) {
        super(dao);
    }

    public UstavkaParamSys getById(Integer id) {
        return dao.getById(id);
    }

    public UstavkaParamSys save(UstavkaParamSys ustavkaParamSys) {
        return dao.save(ustavkaParamSys);
    }
}
