package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.model.Page;
import ru.rushydro.vniig.service.PassportParamSysService;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by nikolay on 25.10.15.
 */
@RequestMapping("/enter")
@Controller
public class EnterController {

    @Autowired
    PassportParamSysService sensorService;

    @RequestMapping("/operateJournal")
    public String showOperateJournal (Model model, @RequestParam(value = "page", defaultValue = "1") Long page,
                                      @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {

        Page<PassportParamSys> passportParamSysPage = sensorService.getSensorPageByType(1, page, pageSize);
        model.addAttribute("page", passportParamSysPage);

        return "operateJournal";
    }

}
