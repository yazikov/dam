package ru.rushydro.vniig.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "SIGN_SYS")
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
    @ManyToOne
    @JoinColumn(name = "sort_sign")
    TypeSignalTable sortSign;
    @Column(name = "id_sensors")
    Integer idSensors;

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

    public TypeSignalTable getSortSign() {
        return sortSign;
    }

    public void setSortSign(TypeSignalTable sortSign) {
        this.sortSign = sortSign;
    }

    public Integer getIdSensors() {
        return idSensors;
    }

    public void setIdSensors(Integer idSensors) {
        this.idSensors = idSensors;
    }
}