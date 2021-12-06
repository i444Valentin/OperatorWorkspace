package com.atc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "ТипыТелефонов", schema = "dbo", catalog = "ATCAbonents")
public class PhoneTypesEntity {
    private int id;
    private String типТелефона;
    private Collection<PhonesEntity> телефоныsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ТипТелефона", nullable = false, length = 30)
    public String getТипТелефона() {
        return типТелефона;
    }

    public void setТипТелефона(String типТелефона) {
        this.типТелефона = типТелефона;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneTypesEntity that = (PhoneTypesEntity) o;

        if (id != that.id) return false;
        if (типТелефона != null ? !типТелефона.equals(that.типТелефона) : that.типТелефона != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (типТелефона != null ? типТелефона.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "типыТелефоновByIdТипТелефона")
    public Collection<PhonesEntity> getТелефоныsById() {
        return телефоныsById;
    }

    public void setТелефоныsById(Collection<PhonesEntity> телефоныsById) {
        this.телефоныsById = телефоныsById;
    }
}

