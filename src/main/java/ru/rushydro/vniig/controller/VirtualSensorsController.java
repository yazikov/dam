package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rushydro.vniig.entry.MeasParamTypeSig;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.service.PassportParamSysService;
import ru.rushydro.vniig.storage.entry.PassportParamSysStorage;
import ru.rushydro.vniig.storage.service.PassportParamSysStorageService;

import java.util.Date;

/**
 * Created by nikolay on 07.02.16.
 */
@RequestMapping("/virtual/sensors")
@Controller
public class VirtualSensorsController {

    @Autowired
    PassportParamSysService passportParamSysService;

    @Autowired
    PassportParamSysStorageService passportParamSysStorageService;

//    @Autowired
//    MeasParamTypeSigService measParamTypeSigService;
//
//    @Autowired
//    MeasParamTypeSigStorageService measParamTypeSigService;

    @RequestMapping()
    public String showVirualSensors (Model model) {

        model.addAttribute("sensors", passportParamSysService.getSensorByType(4));

        return "virtualSensors";
    }

    @RequestMapping("/add")
    public String addSensor (Model model) {

        model.addAttribute("sensor", new PassportParamSys());
        model.addAttribute("types", passportParamSysService.getRootComboItems());

        return "sensor";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editSensor (Model model, @PathVariable Integer id) {

        PassportParamSys passportParamSys = passportParamSysService.getById(id);

        if (passportParamSys == null || passportParamSys.getType() == 1 ||
                passportParamSys.getType() == 2 || passportParamSys.getType() == 3) {
            passportParamSys = new PassportParamSys();
        }

        model.addAttribute("sensor", passportParamSys);
        model.addAttribute("types", passportParamSysService.getRootComboItems());

        return "sensor";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSensor (Model model, @RequestParam(defaultValue = "-1") Integer id,
              @RequestParam String objMonitor, @RequestParam String name,
              @RequestParam String number, @RequestParam String parametr,
              @RequestParam(required = false) Double value, @RequestParam(required = false) String date,
              @RequestParam(required = false) String time) {

        PassportParamSys sensor;
        PassportParamSysStorage sensorStorage;
        if (id != -1) {
            sensor = passportParamSysService.getById(id);
            sensorStorage = passportParamSysStorageService.getById(id);
        } else {
            sensor = new PassportParamSys();
            sensorStorage = new PassportParamSysStorage();
        }

        sensor.setName(name);
        sensor.setObjMonitor(objMonitor);
        sensor.setNumber(number);
//        sensor.setMeasParamTypeSig();

        sensorStorage.setName(name);
        sensorStorage.setObjMonitor(objMonitor);
        sensorStorage.setNumber(number);

        return "sensor";
    }

}
