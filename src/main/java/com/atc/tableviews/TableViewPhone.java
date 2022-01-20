package com.atc.tableviews;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class TableViewPhone {
    private Long number;
    private String abonent;
    private String phoneType;
    private String tariff;
    private Integer discount;
    private Integer idAbonentH;
    private String mount;
    private String mountType;

    public TableViewPhone(Long number, String abonent, String phoneType, String tariff, Integer discount, Integer idAbonentH, String mount, String mountType) {
        this.number = number;
        this.abonent = abonent;
        this.phoneType = phoneType;
        this.tariff = tariff;
        this.discount = discount;
        this.idAbonentH = idAbonentH;
        this.mount = mount;
        this.mountType = mountType;
    }

    public TableViewPhone() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAbonent() {
        return abonent;
    }

    public void setAbonent(String abonent) {
        this.abonent = abonent;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getIdAbonentH() {
        return idAbonentH;
    }

    public void setIdAbonentH(Integer idAbonentH) {
        this.idAbonentH = idAbonentH;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getMountType() {
        return mountType;
    }

    public void setMountType(String mountType) {
        this.mountType = mountType;
    }

    public boolean isNullFields() {
        return number == null && abonent == null
                && phoneType == null && tariff == null
                && discount == null && mount == null && mountType == null;
    }
}
