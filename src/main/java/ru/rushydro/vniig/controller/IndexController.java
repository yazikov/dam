package ru.rushydro.vniig.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rushydro.vniig.entry.Insision;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.service.InsisionService;
import ru.rushydro.vniig.service.PassportParamSysService;

import java.util.List;

/**
 * Created by nikolay on 06.09.15.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {
    final static Logger log = Logger.getLogger(IndexController.class);

    @Autowired
    PassportParamSysService sensorService;

    @Autowired
    InsisionService insisionService;
    
    @RequestMapping(path = "/")
    public String indexPage(Model model) {

        log.info("test");
        log.debug("test debug");

        List<String> roots = sensorService.getAllRootNodes();
        List<PassportParamSys> passportParamSysList = sensorService.getSensorByType(1);

        List<Insision> insisions = insisionService.getAllInsision();

        model.addAttribute("roots", roots);
        model.addAttribute("sensors", passportParamSysList);
        model.addAttribute("insisions", insisions);
        return "index";
    }
}
