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

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        if (idSensors != null) {
            sb.append("id:").append(idSensors);
        }

        if (sensorsType != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("name:").append("\"").append(sensorsType).append("\"");
        }

        if (xValue != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("x:").append(xValue);
        }

        if (yValue != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("y:").append(yValue);
        }

        return "{" + sb.toString() + "}";
    }
}
