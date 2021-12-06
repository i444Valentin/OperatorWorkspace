package com.atc.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "Операторы", schema = "dbo", catalog = "ATCAbonents")
public class OperatorsEntity {
    private int id;
    private String имя;
    private String фамилия;
    private String отчество;
    private Date датаРождения;
    private boolean пол;
    private OperatorAccountsEntity операторыАккаунтыById;
    private Collection<RegistrationEntity> регистрацияsById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "имя", nullable = false, length = 30)
    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    @Basic
    @Column(name = "фамилия", nullable = false, length = 30)
    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    @Basic
    @Column(name = "отчество", nullable = false, length = 30)
    public String getОтчество() {
        return отчество;
    }

    public void setОтчество(String отчество) {
        this.отчество = отчество;
    }

    @Basic
    @Column(name = "дата_рождения", nullable = false)
    public Date getДатаРождения() {
        return датаРождения;
    }

    public void setДатаРождения(Date датаРождения) {
        this.датаРождения = датаРождения;
    }

    @Basic
    @Column(name = "пол", nullable = false)
    public boolean isПол() {
        return пол;
    }

    public void setПол(boolean пол) {
        this.пол = пол;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatorsEntity that = (OperatorsEntity) o;

        if (id != that.id) return false;
        if (пол != that.пол) return false;
        if (имя != null ? !имя.equals(that.имя) : that.имя != null) return false;
        if (фамилия != null ? !фамилия.equals(that.фамилия) : that.фамилия != null) return false;
        if (отчество != null ? !отчество.equals(that.отчество) : that.отчество != null) return false;
        if (датаРождения != null ? !датаРождения.equals(that.датаРождения) : that.датаРождения != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (имя != null ? имя.hashCode() : 0);
        result = 31 * result + (фамилия != null ? фамилия.hashCode() : 0);
        result = 31 * result + (отчество != null ? отчество.hashCode() : 0);
        result = 31 * result + (датаРождения != null ? датаРождения.hashCode() : 0);
        result = 31 * result + (пол ? 1 : 0);
        return result;
    }

    @OneToOne(mappedBy = "операторыById")
    public OperatorAccountsEntity getОператорыАккаунтыById() {
        return операторыАккаунтыById;
    }

    public void setОператорыАккаунтыById(OperatorAccountsEntity операторыАккаунтыById) {
        this.операторыАккаунтыById = операторыАккаунтыById;
    }


    @OneToMany(mappedBy = "операторыByIdОператор")
    public Collection<RegistrationEntity> getРегистрацияsById() {
        return регистрацияsById;
    }

    public void setРегистрацияsById(Collection<RegistrationEntity> регистрацияsById) {
        this.регистрацияsById = регистрацияsById;
    }

}
