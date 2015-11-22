package ru.rushydro.vniig.storage.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by nikolay on 22.11.15.
 */
@Entity
@Table(name = "USTAVKA_PARAM_SYS")
public class UstavkaParamSysStorage extends AbstractStorageEntry {
    @Id
    @Column(name = "id_ustavka")
    Integer idUstavka;
    @Column(name = "discription")
    String discription;
    @Column(name = "date_ustavka")
    Date dateUstavka;
    @Column(name = "value_ustavka_pre")
    Float valueUstavkaPre;
    @Column(name = "value_ustavka_av")
    Float valueUstavkaAv;

    public Integer getIdUstavka() {
        return idUstavka;
    }

    public void setIdUstavka(Integer idUstavka) {
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
