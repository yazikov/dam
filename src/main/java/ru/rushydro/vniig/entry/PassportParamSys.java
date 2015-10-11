package ru.rushydro.vniig.entry;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "PASSPORT_PARAM_SYS")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PassportParamSys extends AbstractEntry {
    @Column(name = "OBJ_MONITOR")
    String objMonitor;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "MEAS_PARAM_TYPE_SIG")
    MeasParamTypeSig measParamTypeSig;

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sensors")
    MeasParamSys measParamSys;

    public SignSys getSignSys() {
        return signSys;
    }

    public void setSignSys(SignSys signSys) {
        this.signSys = signSys;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sensors")
    SignSys signSys;

    public PassportParamSys() {
    }

    public String getObjMonitor() {
        return objMonitor;
    }

    public void setObjMonitor(String objMonitor) {
        this.objMonitor = objMonitor;
    }

    public MeasParamTypeSig getMeasParamTypeSig() {
        return measParamTypeSig;
    }

    public void setMeasParamTypeSig(MeasParamTypeSig measParamTypeSig) {
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

        if (getValue() != null) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("value:").append("\"").append(getValue()).append("\"");
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

        if (measParamSys != null && measParamSys.getWorkSensors() != null && !measParamSys.getWorkSensors()) {
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("type:").append(4);
            if (!sb.toString().isEmpty()) {
                sb.append(",");
            }
            sb.append("text:").append("\'\'");
        } else {
            if (signSys != null) {
                if (signSys.getSortSign() != null && signSys.getSortSign().getTextSignal() != null) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(",");
                    }
                    sb.append("text:").append("\'").append(signSys.getSortSign().getTextSignal()).append("\'");
                }
                if (signSys.getSortSign() != null && signSys.getSortSign().getIdSignal() != null) {
                    if (!sb.toString().isEmpty()) {
                        sb.append(",");
                    }
                    sb.append("type:").append(signSys.getSortSign().getIdSignal());
                }
            }
        }

        return "{" + sb.toString() + "}";
    }

    public int getType() {
        if (measParamSys != null && measParamSys.getWorkSensors() != null && !measParamSys.getWorkSensors()) {
            return 4;
        } else {
            if (signSys.getSortSign() != null && signSys.getSortSign().getIdSignal() != null) {
                return signSys.getSortSign().getIdSignal();
            } else {
                return 1;
            }
        }
    }

    public String getText () {
        return signSys != null && signSys.getSortSign() != null ? signSys.getSortSign().getTextSignal() : "";
    }

    public Float getValue () {
        return measParamSys != null && measParamSys.getValueMeas() != null ? measParamSys.getValueMeas() : 0;
    }
}
