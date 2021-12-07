package com.atc.tableviews;

public class TableViewAbonent {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthDate;
    private String gender;

    public TableViewAbonent(String fName, String lName, String patronymic, String birthDate, String gender) {
        this.firstName = fName;
        this.lastName = lName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
