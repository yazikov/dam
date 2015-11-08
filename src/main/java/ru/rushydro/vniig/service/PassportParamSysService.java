package ru.rushydro.vniig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rushydro.vniig.dao.PassportParamSysDAO;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.model.ComboItem;
import ru.rushydro.vniig.model.JournalItem;
import ru.rushydro.vniig.model.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ComboItem> getRootComboItems () {
        List<ComboItem> items = new ArrayList<>();
        List<String> roots = getAllRootNodes();
        for (String root : roots) {
            ComboItem comboItem = new ComboItem();
            comboItem.setId(root);
            comboItem.setName(root);
            items.add(comboItem);
        }
        return items;
    }

    public List<String> getRootNodesByInsision(Integer insision) {
        return dao.getRootNodesByInsision (insision);
    }

    public List<PassportParamSys> getSensorByType(Integer type) {
        return dao.getSensorByType(type);
    }

    public List<PassportParamSys> getSensorByTypeAndInsision (Integer type, Integer insision) {
        return dao.getSensorByTypeAndInsision(type, insision);
    }


    public Page<PassportParamSys> getSensorPageByType(int type, Long page, Integer pageSize) {
        return dao.getSensorPageByType(type, page, pageSize);
    }

    public Page<JournalItem> getJournalItemPage(int type, Long page, Integer pageSize) {
        Page<PassportParamSys> passportParamSysPage = getSensorPageByType(type, page, pageSize);
        List<JournalItem> list = passportParamSysPage.getContent().stream().map(JournalItem::new).collect(Collectors.toList());

        return new Page<>(page, pageSize, passportParamSysPage.getCount(), list);
    }
}
