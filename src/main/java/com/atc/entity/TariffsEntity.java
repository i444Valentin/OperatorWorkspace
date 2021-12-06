package com.atc.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "Тарифы", schema = "dbo", catalog = "ATCAbonents")
public class TariffsEntity {
    private int id;
    private String названиеТарифа;
    private BigDecimal цена;
    private Integer количествоМинут;
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
    @Column(name = "НазваниеТарифа", nullable = false, length = 20)
    public String getНазваниеТарифа() {
        return названиеТарифа;
    }

    public void setНазваниеТарифа(String названиеТарифа) {
        this.названиеТарифа = названиеТарифа;
    }

    @Basic
    @Column(name = "Цена", nullable = false)
    public BigDecimal getЦена() {
        return цена;
    }

    public void setЦена(BigDecimal цена) {
        this.цена = цена;
    }

    @Basic
    @Column(name = "КоличествоМинут", nullable = true)
    public Integer getКоличествоМинут() {
        return количествоМинут;
    }

    public void setКоличествоМинут(Integer количествоМинут) {
        this.количествоМинут = количествоМинут;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffsEntity that = (TariffsEntity) o;

        if (id != that.id) return false;
        if (названиеТарифа != null ? !названиеТарифа.equals(that.названиеТарифа) : that.названиеТарифа != null)
            return false;
        if (цена != null ? !цена.equals(that.цена) : that.цена != null) return false;
        if (количествоМинут != null ? !количествоМинут.equals(that.количествоМинут) : that.количествоМинут != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (названиеТарифа != null ? названиеТарифа.hashCode() : 0);
        result = 31 * result + (цена != null ? цена.hashCode() : 0);
        result = 31 * result + (количествоМинут != null ? количествоМинут.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "тарифыByТариф")
    public Collection<PhonesEntity> getТелефоныsById() {
        return телефоныsById;
    }

    public void setТелефоныsById(Collection<PhonesEntity> телефоныsById) {
        this.телефоныsById = телефоныsById;
    }
}
