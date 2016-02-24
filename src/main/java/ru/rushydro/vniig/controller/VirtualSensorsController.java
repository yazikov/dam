package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rushydro.vniig.entry.MeasParamSys;
import ru.rushydro.vniig.entry.MeasParamTypeSig;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.entry.UstavkaParamSys;
import ru.rushydro.vniig.service.MeasParamSysService;
import ru.rushydro.vniig.service.PassportParamSysService;
import ru.rushydro.vniig.service.UstavkaParamSysService;
import ru.rushydro.vniig.storage.entry.PassportParamSysStorage;
import ru.rushydro.vniig.storage.entry.UstavkaParamSysStorage;
import ru.rushydro.vniig.storage.service.MeasParamSysStorageService;
import ru.rushydro.vniig.storage.service.PassportParamSysStorageService;
import ru.rushydro.vniig.storage.service.UstavkaParamSysStorageService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    UstavkaParamSysService ustavkaParamSysService;

    @Autowired
    UstavkaParamSysStorageService ustavkaParamSysStorageService;

    @Autowired
    MeasParamSysService measParamSysService;

    @Autowired
    MeasParamSysStorageService measParamSysStorageService;

    @RequestMapping()
    public String showVirualSensors (Model model) {

        model.addAttribute("sensors", passportParamSysService.getSensorByTypeUpper(4));

        return "virtualSensors";
    }

    @RequestMapping("/add")
    public String addSensor (Model model) {

        model.addAttribute("sensor", new PassportParamSys());
        model.addAttribute("types", passportParamSysService.getRootComboItems());
        model.addAttribute("sensorTypes", ustavkaParamSysService.getComboItems());

        return "sensor";
    }

    @RequestMapping("/type/add")
    public String addSensorType (Model model) {

        model.addAttribute("type", new UstavkaParamSys());

        return "type";
    }

    @RequestMapping("/value/add/{id}")
    public String addSensorValue (Model model, @PathVariable Integer id) {

        PassportParamSys passportParamSys = passportParamSysService.getById(id);
        if (passportParamSys == null || passportParamSys.getType() == 1 ||
                passportParamSys.getType() == 2 || passportParamSys.getType() == 3) {
            return "redirect:/virtual/sensors";
        }

        model.addAttribute("sensor", passportParamSys);

        return "type";
    }

    @RequestMapping(value = "/value/add", method = RequestMethod.POST)
    public String addSensorValue (Model model, @RequestParam Integer id,
                                  @RequestParam(required = false) Float value, @RequestParam(required = false) String date,
                                  @RequestParam(required = false) String time) {


        MeasParamSys measParamSysStorage = new MeasParamSys();
        measParamSysStorage.setIdSensors(id);
        measParamSysStorage.setValueMeas(value);
        try {
            measParamSysStorage.setDateMeas(new SimpleDateFormat("dd.MM.yy").parse(date));
            measParamSysStorage.setTimeMeas(new SimpleDateFormat("hh:mm:ss").parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return "redirect:/virtual/sensors";
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
              @RequestParam String number, @RequestParam Integer measParamTypeSig,
              @RequestParam(required = false) Float value, @RequestParam(required = false) String date,
              @RequestParam(required = false) String time, @RequestParam(required = false) Double k1,
                              @RequestParam(required = false) Double k1Low) {

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
        sensor.setMeasParamTypeSig(ustavkaParamSysService.getById(measParamTypeSig));
        sensor.setCriter_release(k1Low);
        sensor.setCriterion(k1);

        sensor = passportParamSysService.save(sensor);

        MeasParamSys measParamSys = new MeasParamSys();
        measParamSys.setIdSensors(sensor.getIdSensors());
        measParamSys.setValueMeas(value);
        try {
            measParamSys.setDateMeas(new SimpleDateFormat("dd.MM.yy").parse(date));
            measParamSys.setTimeMeas(new SimpleDateFormat("hh:mm:ss").parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        measParamSysService.save(measParamSys);

        sensorStorage.setName(name);
        sensorStorage.setObjMonitor(objMonitor);
        sensorStorage.setNumber(number);
        sensorStorage.setMeasParamTypeSig(ustavkaParamSysStorageService.getById(measParamTypeSig));

        sensorStorage = passportParamSysStorageService.save(sensorStorage);

        MeasParamSys measParamSysStorage = new MeasParamSys();
        measParamSysStorage.setIdSensors(sensorStorage.getIdSensors());
        measParamSysStorage.setValueMeas(value);
        try {
            measParamSysStorage.setDateMeas(new SimpleDateFormat("dd.MM.yy").parse(date));
            measParamSysStorage.setTimeMeas(new SimpleDateFormat("hh:mm:ss").parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return "redirect:/virtual/sensors";
    }

    @RequestMapping("/type/save")
    public String saveSensorType (Model model, @RequestParam(defaultValue = "-1", required = false) Integer id, @RequestParam String description) {

        UstavkaParamSys ustavkaParamSys;
        UstavkaParamSysStorage ustavkaParamSysStorage;
        if (id != null && id != -1) {
            ustavkaParamSys = ustavkaParamSysService.getById(id);
            ustavkaParamSysStorage = ustavkaParamSysStorageService.getById(id);
        } else {
            ustavkaParamSys = new UstavkaParamSys();
            ustavkaParamSysStorage = new UstavkaParamSysStorage();
        }

        ustavkaParamSys.setDiscription(description);
        ustavkaParamSysStorage.setDiscription(description);

        ustavkaParamSysService.save(ustavkaParamSys);
        ustavkaParamSysStorageService.save(ustavkaParamSysStorage);


        return "redirect:/virtual/sensors";
    }

}
