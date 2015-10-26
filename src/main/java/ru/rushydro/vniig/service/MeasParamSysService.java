package ru.rushydro.vniig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.dao.MeasParamSysDAO;
import ru.rushydro.vniig.entry.MeasParamSys;

/**
 * Created by nikolay on 26.10.15.
 */
@Service
public class MeasParamSysService extends AbstractService<MeasParamSys, MeasParamSysDAO> {

    @Autowired
    public MeasParamSysService(MeasParamSysDAO dao) {
        super(dao);
    }

    public MeasParamSys getById(Integer id) {
        return dao.getById(id);
    }

    public MeasParamSys save(MeasParamSys measParamSys) {
        return dao.save(measParamSys);
    }

    public MeasParamSys updateValue (Integer id, Double value) {
        return dao.updateValue(id, value);
    }
}
