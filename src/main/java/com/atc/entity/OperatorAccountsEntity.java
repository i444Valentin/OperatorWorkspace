package com.atc.entity;

import javax.persistence.*;

@Entity
@Table(name = "ОператорыАккаунты", schema = "dbo", catalog = "ATCAbonents")
public class OperatorAccountsEntity {
    private int id;
    private String login;
    private String password;
    private OperatorsEntity операторыById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatorAccountsEntity that = (OperatorAccountsEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public OperatorsEntity getОператорыById() {
        return операторыById;
    }

    public void setОператорыById(OperatorsEntity операторыById) {
        this.операторыById = операторыById;
    }

}
