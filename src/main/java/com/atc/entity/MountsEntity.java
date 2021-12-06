package com.atc.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Установки", schema = "dbo", catalog = "ATCAbonents")
public class MountsEntity {
    private long номерТелефона;
    private Date датаУстановки;
    private boolean типУстановки;
    private PhonesEntity телефоныByНомерТелефона;

    @Id
    @Column(name = "НомерТелефона", nullable = false, precision = 0)
    public long getНомерТелефона() {
        return номерТелефона;
    }

    public void setНомерТелефона(long номерТелефона) {
        this.номерТелефона = номерТелефона;
    }

    @Basic
    @Column(name = "ДатаУстановки", nullable = false)
    public Date getДатаУстановки() {
        return датаУстановки;
    }

    public void setДатаУстановки(Date датаУстановки) {
        this.датаУстановки = датаУстановки;
    }

    @Basic
    @Column(name = "ТипУстановки", nullable = false)
    public boolean isТипУстановки() {
        return типУстановки;
    }

    public void setТипУстановки(boolean типУстановки) {
        this.типУстановки = типУстановки;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MountsEntity that = (MountsEntity) o;

        if (номерТелефона != that.номерТелефона) return false;
        if (типУстановки != that.типУстановки) return false;
        if (датаУстановки != null ? !датаУстановки.equals(that.датаУстановки) : that.датаУстановки != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (номерТелефона ^ (номерТелефона >>> 32));
        result = 31 * result + (датаУстановки != null ? датаУстановки.hashCode() : 0);
        result = 31 * result + (типУстановки ? 1 : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "НомерТелефона", referencedColumnName = "номер", nullable = false)
    public PhonesEntity getТелефоныByНомерТелефона() {
        return телефоныByНомерТелефона;
    }

    public void setТелефоныByНомерТелефона(PhonesEntity телефоныByНомерТелефона) {
        this.телефоныByНомерТелефона = телефоныByНомерТелефона;
    }

}
