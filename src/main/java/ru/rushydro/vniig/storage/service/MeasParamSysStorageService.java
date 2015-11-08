package ru.rushydro.vniig.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.storage.dao.MeasParamSysStorageDAO;
import ru.rushydro.vniig.storage.entry.MeasParamSysStorage;

/**
 * Created by nikolay on 07.11.15.
 */
@Service
public class MeasParamSysStorageService extends AbstractStorageService<MeasParamSysStorage, MeasParamSysStorageDAO> {
    @Autowired
    public MeasParamSysStorageService(MeasParamSysStorageDAO dao) {
        super(dao);
    }

    public void insertValue (Integer id, Double value) {
        dao.insertValue(id, value);
    }
}
