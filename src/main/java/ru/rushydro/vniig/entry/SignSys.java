package ru.rushydro.vniig.entry;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by alyon on 27.09.2015.
 */
public class SignSys extends AbstractEntry {
    @Id
    @Column(name = "id_sign")
    Integer idSign;
    @Column(name = "date_sign")
    @Temporal(value= TemporalType.DATE)
    Date dateSign;
    @Column(name = "time_sign")
    @Temporal(value=TemporalType.DATE)
    Date timeSign;
    @Column(name = "sort_sign")
    Integer sortSign;
    @Column(name = "text_sign")
    Integer textSign;
    @Column(name = "id_sensors")
    Integer idSensors;

    public SignSys(Integer idSign, Date dateSign, Date timeSign, Integer sortSign, Integer textSign, Integer idSensors) {
        this.idSign = idSign;
        this.dateSign = dateSign;
        this.timeSign = timeSign;
        this.sortSign = sortSign;
        this.textSign = textSign;
        this.idSensors = idSensors;
    }

    public Integer getIdSign() {
        return idSign;
    }

    public void setIdSign(Integer idSign) {
        this.idSign = idSign;
    }

    public Date getDateSign() {
        return dateSign;
    }

    public void setDateSign(Date dateSign) {
        this.dateSign = dateSign;
    }

    public Date getTimeSign() {
        return timeSign;
    }

    public void setTimeSign(Date timeSign) {
        this.timeSign = timeSign;
    }

    public Integer getSortSign() {
        return sortSign;
    }

    public void setSortSign(Integer sortSign) {
        this.sortSign = sortSign;
    }

    public Integer getTextSign() {
        return textSign;
    }

    public void setTextSign(Integer textSign) {
        this.textSign = textSign;
    }

    public Integer getIdSensors() {
        return idSensors;
    }

    public void setIdSensors(Integer idSensors) {
        this.idSensors = idSensors;
    }
}
