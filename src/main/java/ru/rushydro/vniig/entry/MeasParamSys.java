package ru.rushydro.vniig.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "MEAS_PARAM_SYS")
public class MeasParamSys {
    @Id
    @Column(name = "id_sensors")
    Integer idSensors;
    @Column(name = "status_sensors")
    Integer statusSensors;
    @Column(name = "sort_sensors")
    Integer sortSensors;
    @Column(name = "date_meas")
    @Temporal(value= TemporalType.DATE)
    Date dateMeas;
    @Column(name = "time_meas")
//    @Temporal(value= TemporalType.DATE)
            Date timeMeas;
    @Column(name = "sort_meas")
    Integer sortMeas;
    @Column(name = "value_meas")
    Float value_meas;
    @Column(name = "trust_meas")
    Integer trustMeas;
    @Column(name = "work_sensors")
    Boolean workSensors;

    public MeasParamSys(Integer idSensors, Integer statusSensors, Integer sortSensors, Date dateMeas, Date timeMeas, Float value_meas, Integer sortMeas, Integer trustMeas, Boolean workSensors) {
        this.idSensors = idSensors;
        this.statusSensors = statusSensors;
        this.sortSensors = sortSensors;
        this.dateMeas = dateMeas;
        this.timeMeas = timeMeas;
        this.value_meas = value_meas;
        this.sortMeas = sortMeas;
        this.trustMeas = trustMeas;
        this.workSensors = workSensors;
    }

    public Integer getIdSensors() {
        return idSensors;
    }

    public void setIdSensors(Integer idSensors) {
        this.idSensors = idSensors;
    }

    public Integer getStatusSensors() {
        return statusSensors;
    }

    public void setStatusSensors(Integer statusSensors) {
        this.statusSensors = statusSensors;
    }

    public Integer getSortSensors() {
        return sortSensors;
    }

    public void setSortSensors(Integer sortSensors) {
        this.sortSensors = sortSensors;
    }

    public Date getDateMeas() {
        return dateMeas;
    }

    public void setDateMeas(Date dateMeas) {
        this.dateMeas = dateMeas;
    }

    public Date getTimeMeas() {
        return timeMeas;
    }

    public void setTimeMeas(Date timeMeas) {
        this.timeMeas = timeMeas;
    }

    public Integer getSortMeas() {
        return sortMeas;
    }

    public void setSortMeas(Integer sortMeas) {
        this.sortMeas = sortMeas;
    }

    public Float getValue_meas() {
        return value_meas;
    }

    public void setValue_meas(Float value_meas) {
        this.value_meas = value_meas;
    }

    public Integer getTrustMeas() {
        return trustMeas;
    }

    public void setTrustMeas(Integer trustMeas) {
        this.trustMeas = trustMeas;
    }

    public Boolean getWorkSensors() {
        return workSensors;
    }

    public void setWorkSensors(Boolean workSensors) {
        this.workSensors = workSensors;
    }
}