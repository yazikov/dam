package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.model.Page;
import ru.rushydro.vniig.service.PassportParamSysService;
import ru.rushydro.vniig.service.TypeSignalTableService;
import ru.rushydro.vniig.storage.service.SignSysStorageService;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

/**
 * Created by nikolay on 25.10.15.
 */
@RequestMapping("/enter")
@Controller
public class EnterController {

    @Autowired
    PassportParamSysService sensorService;

    @Autowired
    SignSysStorageService signSysStorageService;

    @Autowired
    TypeSignalTableService typeSignalTableService;

    @RequestMapping("/operateJournal")
    public String showOperateJournal (Model model, @RequestParam(value = "page", defaultValue = "1") Long page,
                                      @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {

        model.addAttribute("page", sensorService.getJournalItemPage(1, page, pageSize));
        model.addAttribute("operate", true);

        return "journal";
    }

    @RequestMapping("/history")
    public String showHistory (Model model,
                               @RequestParam(value = "startDate", defaultValue = "") String startDate,
                               @RequestParam(value = "endDate", defaultValue = "") String endDate,
                               @RequestParam(value = "type", defaultValue = "") String type,
                               @RequestParam(value = "signal", defaultValue = "") String signal,
                               @RequestParam(value = "page", defaultValue = "1") Long page,
                               @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {

        model.addAttribute("page", signSysStorageService.filterJournalItem(page, pageSize));
        model.addAttribute("operate", false);

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("type", type);
        model.addAttribute("signal", signal);

        model.addAttribute("types", sensorService.getRootComboItems());
        model.addAttribute("signals", typeSignalTableService.getComboItems());

        return "journal";
    }

}
