package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.rushydro.vniig.dao.PassportParamSysDAO;
import ru.rushydro.vniig.model.SensorUpdateData;
import ru.rushydro.vniig.util.data.UpdateTimeUtil;

import java.beans.PropertyEditorSupport;

/**
 * Created by nikolay on 11.10.15.
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    UpdateTimeUtil updateTimeUtil;

    @Autowired
    PassportParamSysDAO passportParamSysDAO;

    @RequestMapping(value = "/updateSensor", method = RequestMethod.GET)
    public @ResponseBody SensorUpdateData getSensorUpdateData() {
        SensorUpdateData sensorUpdateData = new SensorUpdateData();
        sensorUpdateData.setUpdate(updateTimeUtil.isUpdateTime());
        if (sensorUpdateData.getUpdate()) {
            sensorUpdateData.setSensors(passportParamSysDAO.getSensorByType(1));
        }
        return sensorUpdateData;
    }

//    @InitBinder
//    public void binder(WebDataBinder binder) {
//        binder.registerCustomEditor(SensorUpdateData.class, new PropertyEditorSupport());
//    }
}
