package ru.rushydro.vniig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.dao.PassportParamSysDAO;
import ru.rushydro.vniig.entry.PassportParamSys;

import java.util.List;

/**
 * Created by nikolay on 04.10.15.
 */
@Service
public class PassportParamSysService extends AbstractService<PassportParamSys, PassportParamSysDAO>  {

    @Autowired
    public PassportParamSysService(PassportParamSysDAO dao) {
        super(dao);
    }

    public List<String> getAllRootNodes() {
        return dao.getAllRootNodes();
    }

    public List<PassportParamSys> getSensorByType(Integer type) {
        return dao.getSensorByType(1);
    }
}
