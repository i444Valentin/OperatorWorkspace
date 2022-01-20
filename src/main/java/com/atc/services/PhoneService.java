package com.atc.services;

import com.atc.dao.PhoneDao;
import com.atc.entity.AbonentsEntity;
import com.atc.entity.PhonesEntity;

import java.util.List;

public class PhoneService {
    PhoneDao phoneDao = new PhoneDao();

    public PhonesEntity  findPhone(int number) {
        return phoneDao.findById(number);

    }

    public void savePhone(PhonesEntity phone) {
        phoneDao.save(phone);

    }

    public void updatePhone(PhonesEntity phone) {
        phoneDao.update(phone);

    }

    public void deletePhone(PhonesEntity phone) {
        phoneDao.delete(phone);

    }

    public List<PhonesEntity> findAllPhones() {
        return phoneDao.findAll();
    }

}
