package com.atc.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Регистрация", schema = "dbo", catalog = "ATCAbonents")
public class RegistrationEntity {
    private int id;
    private Date датаРегистрации;
    private OperatorsEntity операторыByIdОператор;
    private PhonesEntity телефоныByНомерТелефона;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ДатаРегистрации", nullable = false)
    public Date getДатаРегистрации() {
        return датаРегистрации;
    }

    public void setДатаРегистрации(Date датаРегистрации) {
        this.датаРегистрации = датаРегистрации;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistrationEntity that = (RegistrationEntity) o;

        if (id != that.id) return false;
        if (датаРегистрации != null ? !датаРегистрации.equals(that.датаРегистрации) : that.датаРегистрации != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (датаРегистрации != null ? датаРегистрации.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IDОператор", referencedColumnName = "ID", nullable = false)
    public OperatorsEntity getОператорыByIdОператор() {
        return операторыByIdОператор;
    }

    public void setОператорыByIdОператор(OperatorsEntity операторыByIdОператор) {
        this.операторыByIdОператор = операторыByIdОператор;
    }


    @ManyToOne
    @JoinColumn(name = "НомерТелефона", referencedColumnName = "номер", nullable = false)
    public PhonesEntity getТелефоныByНомерТелефона() {
        return телефоныByНомерТелефона;
    }

    public void setТелефоныByНомерТелефона(PhonesEntity телефоныByНомерТелефона) {
        this.телефоныByНомерТелефона = телефоныByНомерТелефона;
    }

}
