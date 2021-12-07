package com.atc.services;

import com.atc.dao.AbonentDao;
import com.atc.entity.AbonentsEntity;

import java.util.List;

public class AbonentService {

    AbonentDao abonentDao = new AbonentDao();

    public AbonentsEntity findAbonent(int id) {
        return abonentDao.findById(id);

    }

    public void saveAbonent(AbonentsEntity abonent) {
        abonentDao.save(abonent);

    }

    public void updateAbonent(AbonentsEntity abonent) {
        abonentDao.update(abonent);

    }

    public void deleteAbonent(AbonentsEntity abonent) {
        abonentDao.delete(abonent);

    }

    public List<AbonentsEntity> findByInitials(String firstname,String lastname, String patronymic){
        return abonentDao.findByInicials(firstname,lastname,patronymic);
    }

    public List<AbonentsEntity> findAllAbonents() {
        return abonentDao.findAll();
    }

    public AbonentsEntity findAbonentWithName(String fname,String lname, String patronymic) {
        return null;
    }
}
