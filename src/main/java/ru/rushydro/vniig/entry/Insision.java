package ru.rushydro.vniig.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by alyon on 18.10.2015.
 */
@Entity
@Table(name = "INSISION_PARAM")
public class Insision extends AbstractEntry{
    @Id
    @Column(name = "ID_INSISION")
    Integer idInsision;

    @Column(name = "NAME_INS")
    String nameIns;

    @Column(name = "X_START")
    Integer xStart;

    @Column(name = "Y_START")
    Integer yStart;

    @Column(name = "X_END")
    Integer xEnd;

    @Column(name = "Y_END")
    Integer yEnd;

    public Integer getIdInsision() {
        return idInsision;
    }

    public void setIdInsision(Integer idInsision) {
        this.idInsision = idInsision;
    }

    public String getNameIns() {
        return nameIns;
    }

    public void setNameIns(String nameIns) {
        this.nameIns = nameIns;
    }

    public Integer getxStart() {
        return xStart;
    }

    public void setxStart(Integer xStart) {
        this.xStart = xStart;
    }

    public Integer getyStart() {
        return yStart;
    }

    public void setyStart(Integer yStart) {
        this.yStart = yStart;
    }

    public Integer getxEnd() {
        return xEnd;
    }

    public void setxEnd(Integer xEnd) {
        this.xEnd = xEnd;
    }

    public Integer getyEnd() {
        return yEnd;
    }

    public void setyEnd(Integer yEnd) {
        this.yEnd = yEnd;
    }
}
