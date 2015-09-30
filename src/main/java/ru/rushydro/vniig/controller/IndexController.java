package ru.rushydro.vniig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rushydro.vniig.dao.PasportParamSys;

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
        List<PasportParamSys> pasportParamSysList = new ArrayList<>();
        PasportParamSys sensor = new PasportParamSys();
        sensor.setIdSensors(0);
        sensor.setxValue(391f);
        sensor.setyValue(538f);
        sensor.setSensorsType("П-10");
        pasportParamSysList.add(sensor);

        sensor = new PasportParamSys();
        sensor.setIdSensors(1);
        sensor.setxValue(387f);
        sensor.setyValue(560f);
        sensor.setSensorsType("П-9");
        pasportParamSysList.add(sensor);

        sensor = new PasportParamSys();
        sensor.setIdSensors(2);
        sensor.setxValue(377f);
        sensor.setyValue(608f);
        sensor.setSensorsType("П-28");
        pasportParamSysList.add(sensor);

        sensor = new PasportParamSys();
        sensor.setIdSensors(3);
        sensor.setxValue(369f);
        sensor.setyValue(634f);
        sensor.setSensorsType("П-27");
        pasportParamSysList.add(sensor);

        model.addAttribute("sensors",pasportParamSysList);
        return "index";
    }

    @RequestMapping(path = "/test")
    public String testPage(Model model) {
        return "test";
    }
}
