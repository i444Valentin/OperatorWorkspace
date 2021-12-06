package com.atc.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Телефоны", schema = "dbo", catalog = "ATCAbonents")
public class PhonesEntity {
    private long номер;
    private Integer льгота;
    private Collection<RegistrationEntity> регистрацияsByНомер;
    private AbonentsEntity абонентыByIdАбонент;
    private PhoneTypesEntity типыТелефоновByIdТипТелефона;
    private TariffsEntity тарифыByТариф;
    private MountsEntity установкиByНомер;

    @Id
    @Column(name = "номер", nullable = false, precision = 0)
    public long getНомер() {
        return номер;
    }

    public void setНомер(long номер) {
        this.номер = номер;
    }

    @Basic
    @Column(name = "льгота", nullable = true)
    public Integer getЛьгота() {
        return льгота;
    }

    public void setЛьгота(Integer льгота) {
        this.льгота = льгота;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhonesEntity that = (PhonesEntity) o;

        if (номер != that.номер) return false;
        if (льгота != null ? !льгота.equals(that.льгота) : that.льгота != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (номер ^ (номер >>> 32));
        result = 31 * result + (льгота != null ? льгота.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "телефоныByНомерТелефона")
    public Collection<RegistrationEntity> getРегистрацияsByНомер() {
        return регистрацияsByНомер;
    }

    public void setРегистрацияsByНомер(Collection<RegistrationEntity> регистрацияsByНомер) {
        this.регистрацияsByНомер = (Collection<RegistrationEntity>) регистрацияsByНомер;
    }


    @ManyToOne
    @JoinColumn(name = "IDАбонент", referencedColumnName = "ID", nullable = false)
    public AbonentsEntity getАбонентыByIdАбонент() {
        return абонентыByIdАбонент;
    }

    public void setАбонентыByIdАбонент(AbonentsEntity абонентыByIdАбонент) {
        this.абонентыByIdАбонент = абонентыByIdАбонент;
    }


    @ManyToOne
    @JoinColumn(name = "IDТип_телефона", referencedColumnName = "ID")
    public PhoneTypesEntity getТипыТелефоновByIdТипТелефона() {
        return типыТелефоновByIdТипТелефона;
    }

    public void setТипыТелефоновByIdТипТелефона(PhoneTypesEntity типыТелефоновByIdТипТелефона) {
        this.типыТелефоновByIdТипТелефона = типыТелефоновByIdТипТелефона;
    }

    @ManyToOne
    @JoinColumn(name = "тариф", referencedColumnName = "ID")
    public TariffsEntity getТарифыByТариф() {
        return тарифыByТариф;
    }

    public void setТарифыByТариф(TariffsEntity тарифыByТариф) {
        this.тарифыByТариф = тарифыByТариф;
    }

    @OneToOne(mappedBy = "телефоныByНомерТелефона")
    public MountsEntity getУстановкиByНомер() {
        return установкиByНомер;
    }


    public void setУстановкиByНомер(MountsEntity установкиByНомер) {
        this.установкиByНомер = установкиByНомер;
    }
}
