package ru.rushydro.vniig.entry;

import javax.persistence.*;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "PASSPORT_PARAM_SYS")
public class PassportParamSys extends AbstractEntry {
    @Column(name = "OBJ_MONITOR")
    String objMonitor;

    @Column(name = "MEAS_PARAM_TYPE_SIG")
    Integer measParamTypeSig;

    @Column(name = "NAME_SENSORS")
    String name;

    @Column(name = "SORT_SIGN")
    String sortSign;

    @Column(name = "TYPE_OF_SENSOR")
    String typeOfSensor;

    @Column(name = "NUMBER_OF_SENSOR")
    String number;

    @Id
    @Column(name = "id_sensors")
    Integer idSensors;
    @Column(name = "x_value")
    Integer xValue;
    @Column(name = "y_value")
    Integer yValue;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sensors")
    MeasParamSys measParamSys;

    Double currentValue;

    public PassportParamSys() {
    }

    public String getObjMonitor() {
        return objMonitor;
    }

    public void setObjMonitor(String objMonitor) {
        this.objMonitor = objMonitor;
    }

    public Integer getMeasParamTypeSig() {
        return measParamTypeSig;
    }

    public void setMeasParamTypeSig(Integer measParamTypeSig) {
        this.measParamTypeSig = measParamTypeSig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortSign() {
        return sortSign;
    }

    public void setSortSign(String sortSign) {
        this.sortSign = sortSign;
    }

    public String getTypeOfSensor() {
        return typeOfSensor;
    }

    public void setTypeOfSensor(String typeOfSensor) {
        this.typeOfSensor = typeOfSensor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getIdSensors() {
        return idSensors;
    }

    public void setIdSensors(Integer idSensors) {
        this.idSensors = idSensors;
    }

    public Integer getxValue() {
        return xValue;
    }

    public void setxValue(Integer xValue) {
        this.xValue = xValue;
    }

    public Integer getyValue() {
        return yValue;
    }

    public void setyValue(Integer yValue) {
        this.yValue = yValue;
    }

    public MeasParamSys getMeasParamSys() {
        return measParamSys;
    }

    public void setMeasParamSys(MeasParamSys measParamSys) {
        this.measParamSys = measParamSys;
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

        if (name != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("name:").append("\"").append(name).append("\"");
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
