package com.atc.tableviews;

public class TableViewRegistration {
    private Integer id;
    private String operator;
    private Long phoneNumber;
    private String regDate;

    public TableViewRegistration(Integer id, String operator, Long phoneNumber, String regDate) {
        this.id = id;
        this.operator = operator;
        this.phoneNumber = phoneNumber;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
