package ru.rushydro.vniig.entry;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "USTAVKA_PARAM_SYS")
public class UstavkaParamSys {
    @Id
    @Column(name = "id_ustavka")
    String idUstavka;
    @Column(name = "date_ustavka")
    @Temporal(value= TemporalType.DATE)
    Date dateUstavka;
    @Column(name = "value_ustavka_pre")
    Float valueUstavkaPre;
    @Column(name = "value_ustavka_av")
    Float valueUstavkaAv;
    @Column(name = "coeff_return")
    Float coeffReturn;

    public String getIdUstavka() {
        return idUstavka;
    }

    public void setIdUstavka(String idUstavka) {
        this.idUstavka = idUstavka;
    }

    public Date getDateUstavka() {
        return dateUstavka;
    }

    public void setDateUstavka(Date dateUstavka) {
        this.dateUstavka = dateUstavka;
    }

    public Float getValueUstavkaPre() {
        return valueUstavkaPre;
    }

    public void setValueUstavkaPre(Float valueUstavkaPre) {
        this.valueUstavkaPre = valueUstavkaPre;
    }

    public Float getValueUstavkaAv() {
        return valueUstavkaAv;
    }

    public void setValueUstavkaAv(Float valueUstavkaAv) {
        this.valueUstavkaAv = valueUstavkaAv;
    }

    public Float getCoeffReturn() {
        return coeffReturn;
    }

    public void setCoeffReturn(Float coeffReturn) {
        this.coeffReturn = coeffReturn;
    }
}