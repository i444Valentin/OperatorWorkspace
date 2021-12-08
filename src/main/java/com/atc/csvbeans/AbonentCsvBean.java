package com.atc.csvbeans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class AbonentCsvBean extends CsvBean{
    @CsvBindByName(column = "ID",required = true)
    @CsvBindByPosition(position = 0)
    private Integer id;
    @CsvBindByName(column = "Имя",required = true)
    @CsvBindByPosition(position = 1)
    private String firstname;
    @CsvBindByName(column = "Фамилия",required = true)
    @CsvBindByPosition(position = 2)
    private String secondname;
    @CsvBindByName(column = "Отчество",required = true)
    @CsvBindByPosition(position = 3)
    private String patronymic;
    @CsvBindByName(column = "Дата рождения",required = true)
    @CsvBindByPosition(position = 4)
    private String birthdate;
    @CsvBindByName(column = "Пол",required = true)
    @CsvBindByPosition(position = 5)
    private String gender;

    public AbonentCsvBean(Integer id, String firstname, String secondname, String patronymic, String birthdate, String gender) {
        this.id =id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
