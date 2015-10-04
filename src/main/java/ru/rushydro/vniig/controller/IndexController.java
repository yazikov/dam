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

        List<PassportParamSys> passportParamSysList = new ArrayList<>();
        PassportParamSys sensor = new PassportParamSys();
        sensor.setIdSensors(0);
        sensor.setxValue(391);
        sensor.setyValue(538);
        sensor.setName("П-10");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(1);
        sensor.setxValue(387);
        sensor.setyValue(560);
        sensor.setName("П-9");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(2);
        sensor.setxValue(377);
        sensor.setyValue(608);
        sensor.setName("П-28");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(3);
        sensor.setxValue(369);
        sensor.setyValue(634);
        sensor.setName("П-27");
        passportParamSysList.add(sensor);

        model.addAttribute("sensors",passportParamSysList);
        return "index";
    }

    @RequestMapping(path = "/test")
    public String testPage() {
        return "test";
    }
}
