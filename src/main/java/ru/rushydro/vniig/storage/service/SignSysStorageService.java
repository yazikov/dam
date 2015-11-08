package ru.rushydro.vniig.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.model.JournalItem;
import ru.rushydro.vniig.model.Page;
import ru.rushydro.vniig.storage.dao.SignSysStorageDAO;
import ru.rushydro.vniig.storage.entry.SignSysStorage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nikolay on 07.11.15.
 */
@Service
public class SignSysStorageService extends AbstractStorageService<SignSysStorage, SignSysStorageDAO> {
    @Autowired
    public SignSysStorageService(SignSysStorageDAO dao) {
        super(dao);
    }

    public Page<SignSysStorage> filter(Long page, Integer pageSize) {
        return dao.filter(page, pageSize);
    }

    public Page<JournalItem> filterJournalItem (Long page, Integer pageSize) {
        Page<SignSysStorage> signSysStoragePage = filter(page, pageSize);
        List<JournalItem> journalItems = signSysStoragePage.getContent().stream().map(JournalItem::new).collect(Collectors.toList());

        return new Page<>(page, pageSize, signSysStoragePage.getCount(), journalItems);
    }

    public void insertValues(Integer id, Double value) {
        dao.insertValues(id, value);
    }
}
