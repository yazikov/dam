package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.service.PassportParamSysService;

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
    public String showOperateJournal (Model model) {

        List<PassportParamSys> passportParamSysList = sensorService.getSensorByType(1);
        model.addAttribute("sensors", passportParamSysList);

        return "operateJournal";
    }

}
