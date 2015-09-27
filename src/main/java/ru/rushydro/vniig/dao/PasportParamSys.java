package ru.rushydro.vniig.dao;

/**
 * Created by alyon on 27.09.2015.
 */
public class PasportParamSys {
    String sensorsOaType;
    String sensorsOaElements;
    String sortMeas;
    String typeOfMeas;
    String sensorsGroup;
    String sensorsType;
    Integer idSensors;
    Float xValue;
    Float yValue;

    public PasportParamSys(String sensorsOaType, String sensorsOaElements, String sortMeas, String typeOfMeas, String sensorsGroup, String sensorsType, Float xValue, Integer idSensors, Float yValue) {
        this.sensorsOaType = sensorsOaType;
        this.sensorsOaElements = sensorsOaElements;
        this.sortMeas = sortMeas;
        this.typeOfMeas = typeOfMeas;
        this.sensorsGroup = sensorsGroup;
        this.sensorsType = sensorsType;
        this.xValue = xValue;
        this.idSensors = idSensors;
        this.yValue = yValue;
    }

    public String getSensorsOaType() {
        return sensorsOaType;
    }

    public void setSensorsOaType(String sensorsOaType) {
        this.sensorsOaType = sensorsOaType;
    }

    public String getSortMeas() {
        return sortMeas;
    }

    public void setSortMeas(String sortMeas) {
        this.sortMeas = sortMeas;
    }

    public String getSensorsOaElements() {
        return sensorsOaElements;
    }

    public void setSensorsOaElements(String sensorsOaElements) {
        this.sensorsOaElements = sensorsOaElements;
    }

    public String getTypeOfMeas() {
        return typeOfMeas;
    }

    public void setTypeOfMeas(String typeOfMeas) {
        this.typeOfMeas = typeOfMeas;
    }

    public String getSensorsGroup() {
        return sensorsGroup;
    }

    public void setSensorsGroup(String sensorsGroup) {
        this.sensorsGroup = sensorsGroup;
    }

    public String getSensorsType() {
        return sensorsType;
    }

    public void setSensorsType(String sensorsType) {
        this.sensorsType = sensorsType;
    }

    public Integer getIdSensors() {
        return idSensors;
    }

    public void setIdSensors(Integer idSensors) {
        this.idSensors = idSensors;
    }

    public Float getxValue() {
        return xValue;
    }

    public void setxValue(Float xValue) {
        this.xValue = xValue;
    }

    public Float getyValue() {
        return yValue;
    }

    public void setyValue(Float yValue) {
        this.yValue = yValue;
    }


}
