package ru.rushydro.vniig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rushydro.vniig.entry.PassportParamSys;
import ru.rushydro.vniig.model.GraphicModel;
import ru.rushydro.vniig.model.Page;
import ru.rushydro.vniig.service.PassportParamSysService;
import ru.rushydro.vniig.service.TypeSignalTableService;
import ru.rushydro.vniig.storage.entry.MeasParamSysStorage;
import ru.rushydro.vniig.storage.service.MeasParamSysStorageService;
import ru.rushydro.vniig.storage.service.SignSysStorageService;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by nikolay on 25.10.15.
 */
@RequestMapping("/enter")
@Controller
public class EnterController {

    @Autowired
    PassportParamSysService sensorService;

    @Autowired
    SignSysStorageService signSysStorageService;

    @Autowired
    TypeSignalTableService typeSignalTableService;

    @Autowired
    MeasParamSysStorageService measParamSysStorageService;

    @RequestMapping("/operateJournal")
    public String showOperateJournal (Model model, @RequestParam(value = "page", defaultValue = "1") Long page,
                                      @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {

        model.addAttribute("page", sensorService.getJournalItemPage(1, page, pageSize));
        model.addAttribute("operate", true);

        return "journal";
    }

    @RequestMapping("/history")
    public String showHistory (Model model,
                               @RequestParam(value = "startDate", defaultValue = "") String startDate,
                               @RequestParam(value = "endDate", defaultValue = "") String endDate,
                               @RequestParam(value = "type", defaultValue = "") String type,
                               @RequestParam(value = "signal", defaultValue = "") String signal,
                               @RequestParam(value = "page", defaultValue = "1") Long page,
                               @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {

        model.addAttribute("page", signSysStorageService.filterJournalItem(startDate, endDate, type, signal, page, pageSize));
        model.addAttribute("operate", false);

        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("type", type);
        model.addAttribute("signal", signal);

        model.addAttribute("types", sensorService.getRootComboItems());
        model.addAttribute("signals", typeSignalTableService.getComboItems());

        return "journal";
    }

    @RequestMapping("/trends")
    public String showTrends (Model model,
                              @RequestParam(value = "startDate", defaultValue = "") String startDate,
                              @RequestParam(value = "endDate", defaultValue = "") String endDate) {

        model.addAttribute("sensors", sensorService.getSensorsByRoots());
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "trends";
    }

    @RequestMapping("/graphic")
    public String showGraphic (
            Model model,
            @RequestParam Map<String,String> allRequestParams,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate) {

        List<Integer> sensors = allRequestParams.keySet().stream().filter(key -> key.contains("sensor_")).map(key -> Integer.parseInt(key.replace("sensor_", ""))).collect(Collectors.toList());

        GraphicModel graphic = measParamSysStorageService.getGraphic(startDate, endDate, sensors);
        model.addAttribute("graphic", graphic);

        return "graphic";
    }

    @RequestMapping("/table")
    public String showTable (
            Model model,
            @RequestParam Map<String,String> allRequestParams,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate) {

        List<Integer> sensors = allRequestParams.keySet().stream().filter(key -> key.contains("sensor_")).map(key -> Integer.parseInt(key.replace("sensor_", ""))).collect(Collectors.toList());

        model.addAttribute("sensors", measParamSysStorageService.filter(startDate, endDate, sensors));

        return "table";
    }

    @RequestMapping("/csv")
    public void downloadCSV (HttpServletResponse response,
            Model model,
            @RequestParam Map<String,String> allRequestParams,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate) throws IOException {

        List<Integer> sensors = allRequestParams.keySet().stream().filter(key -> key.contains("sensor_")).map(key -> Integer.parseInt(key.replace("sensor_", ""))).collect(Collectors.toList());

        List<MeasParamSysStorage> values = measParamSysStorageService.filterAndSort(startDate, endDate, sensors);

        StringBuilder sb = new StringBuilder("\"Участок объекта автоматизации\";\"Номер датчика\";\"Измеряемый параметр\";\"Значение\";\"Дата\";\"Время\"");
        int i = 0;
        for (MeasParamSysStorage measParamSysStorage : values) {
            sb.append("\n");

            sb.append("\"");
            if (measParamSysStorage.getPassportParamSys() != null && measParamSysStorage.getPassportParamSys().getObjMonitor() != null && !measParamSysStorage.getPassportParamSys().getObjMonitor().isEmpty()) {
                sb.append(measParamSysStorage.getPassportParamSys().getObjMonitor());
            }
            sb.append("\"");

            sb.append(";");

            sb.append("\"");
            if (measParamSysStorage.getPassportParamSys() != null && measParamSysStorage.getPassportParamSys().getName() != null && !measParamSysStorage.getPassportParamSys().getName().isEmpty()) {
                sb.append(measParamSysStorage.getPassportParamSys().getName());
            }
            sb.append("\"");

            sb.append(";");

            sb.append("\"");
            if (measParamSysStorage.getPassportParamSys() != null && measParamSysStorage.getPassportParamSys().getMeasParamTypeSig() != null && measParamSysStorage.getPassportParamSys().getMeasParamTypeSig().getDiscription() != null && !measParamSysStorage.getPassportParamSys().getMeasParamTypeSig().getDiscription().isEmpty()) {
                sb.append(measParamSysStorage.getPassportParamSys().getMeasParamTypeSig().getDiscription());
            }
            sb.append("\"");

            sb.append(";");

            sb.append("\"");
            if (measParamSysStorage.getValueMeas() != null) {
                sb.append(measParamSysStorage.getValueMeas().toString());
            }
            sb.append("\"");

            sb.append(";");

            sb.append("\"");
            if (measParamSysStorage.getDateMeas() != null) {
                sb.append(new SimpleDateFormat("dd.MM.yyyy").format(measParamSysStorage.getDateMeas()));
            }
            sb.append("\"");

            sb.append(";");

            sb.append("\"");
            if (measParamSysStorage.getTimeMeas() != null) {
                sb.append(new SimpleDateFormat("hh:mm:ss").format(measParamSysStorage.getTimeMeas()));
            }
            sb.append("\"");

            i++;
        }


        String mimeType = "text/csv";

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"sensor_value.csv\""));


        response.setContentLength(sb.toString().length());

        InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes("windows-1251"));

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }

}
