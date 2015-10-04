package ru.rushydro.vniig.entry;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by alyon on 27.09.2015.
 */
@Entity
@Table(name = "TYPE_SIGNAL_TABLE")
public class TypeSignalTable {
    @Id@Column(name = "id_signal")
    Integer idSignal;
    @Column(name = "text_signal")
    String textSignal;


    public TypeSignalTable(Integer idSignal, String textSignal) {
        this.idSignal = idSignal;
        this.textSignal = textSignal;
    }

    public Integer getIdSignal() {
        return idSignal;
    }

    public void setIdSignal(Integer idSignal) {
        this.idSignal = idSignal;
    }

    public String getTextSignal() {
        return textSignal;
    }

    public void setTextSignal(String textSignal) {
        this.textSignal = textSignal;
    }
}