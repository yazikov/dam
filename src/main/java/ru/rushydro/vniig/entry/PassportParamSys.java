package ru.rushydro.vniig.entry;

import javax.persistence.*;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "PASSPORT_PARAM_SYS")
public class PassportParamSys extends AbstractEntry {
    @Column(name = "sensors_oa_type")
    String sensorsOaType;
    @Column(name = "sensors_oa_elements")
    String sensorsOaElements;
    @Column(name = "sort_meas")
    String sortMeas;
    @Column(name = "type_of_meas")
    String typeOfMeas;
    @Column(name = "sensors_group")
    String sensorsGroup;
    @Column(name = "sensors_type")
    String sensorsType;
    @Id
    @Column(name = "id_sensors")
    Integer idSensors;
    @Column(name = "x_value")
    Float xValue;
    @Column(name = "y_value")
    Float yValue;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sensors")
    MeasParamSys measParamSys;

    static String tableName = "PASSPORT_PARAM_SYS";
    public static String getTableName()
    {
        return tableName;
    }
    Double currentValue;

    public PassportParamSys() {
    }

    public PassportParamSys(String sensorsOaType, String sensorsOaElements, String sortMeas, String typeOfMeas, String sensorsGroup, String sensorsType, Float xValue, Integer idSensors, Float yValue) {
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

    public Double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Double currentValue) {
        this.currentValue = currentValue;
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
