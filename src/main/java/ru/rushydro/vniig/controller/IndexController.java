package ru.rushydro.vniig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rushydro.vniig.entry.PassportParamSys;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 06.09.15.
 */
@Controller
@RequestMapping(path = "/")
public class IndexController {
    
    @RequestMapping(path = "/")
    public String indexPage(Model model) {
        List<PassportParamSys> passportParamSysList = new ArrayList<>();
        PassportParamSys sensor = new PassportParamSys();
        sensor.setIdSensors(0);
        sensor.setxValue(391f);
        sensor.setyValue(538f);
        sensor.setSensorsType("П-10");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(1);
        sensor.setxValue(387f);
        sensor.setyValue(560f);
        sensor.setSensorsType("П-9");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(2);
        sensor.setxValue(377f);
        sensor.setyValue(608f);
        sensor.setSensorsType("П-28");
        passportParamSysList.add(sensor);

        sensor = new PassportParamSys();
        sensor.setIdSensors(3);
        sensor.setxValue(369f);
        sensor.setyValue(634f);
        sensor.setSensorsType("П-27");
        passportParamSysList.add(sensor);

        model.addAttribute("sensors",passportParamSysList);
        return "index";
    }

    @RequestMapping(path = "/test")
    public String testPage(Model model) {
        return "test";
    }
}
