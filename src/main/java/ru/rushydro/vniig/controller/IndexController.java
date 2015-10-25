package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.service.PassportParamSysService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 06.09.15.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    PassportParamSysService sensorService;
    
    @RequestMapping(path = "/")
    public String indexPage(Model model) {

        List<String> roots = sensorService.getAllRootNodes();
        List<PassportParamSys> passportParamSysList = sensorService.getSensorByType(1);

        model.addAttribute("roots", roots);
        model.addAttribute("sensors", passportParamSysList);
        return "index";
    }
}
