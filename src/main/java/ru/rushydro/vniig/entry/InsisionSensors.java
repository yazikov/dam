package ru.rushydro.vniig.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by alyon on 18.10.2015.
 */
@Entity
@Table(name = "insision_sensors")
public class InsisionSensors extends AbstractEntry {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "id_insision")
    Integer insision;

    @Column(name = "id_sensors")
    Integer sensors;

    @Column(name = "x_value")
    Integer xValue;

    @Column(name="y_value")
    Integer yValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsision() {
        return insision;
    }

    public void setInsision(Integer insision) {
        this.insision = insision;
    }

    public Integer getSensors() {
        return sensors;
    }

    public void setSensors(Integer sensors) {
        this.sensors = sensors;
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
}
