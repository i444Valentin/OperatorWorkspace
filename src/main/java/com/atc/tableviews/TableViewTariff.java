package com.atc.tableviews;

import java.math.BigDecimal;

public class TableViewTariff {
    private String name;
    private BigDecimal price;
    private Integer minutes;

    public TableViewTariff(String name, BigDecimal price, Integer minutes) {
        this.name = name;
        this.price = price;
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public TableViewTariff() {

    }


    public boolean isNullFields() {
        return name == null && price == null && minutes == null;
    }
}
