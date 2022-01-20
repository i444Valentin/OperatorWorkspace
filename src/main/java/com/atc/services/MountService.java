package com.atc.services;

import com.atc.dao.MountDao;
import com.atc.entity.MountsEntity;
import com.atc.entity.PhonesEntity;

import java.util.List;

public class MountService {
    MountDao mountDao = new MountDao();

    public MountsEntity findPhone(int number) {
        return mountDao.findById(number);

    }

    public void savePhone(MountsEntity phone) {
        mountDao.save(phone);

    }

    public void updatePhone(MountsEntity phone) {
        mountDao.update(phone);

    }

    public void deletePhone(MountsEntity phone) {
        mountDao.delete(phone);

    }

    public List<MountsEntity> findAllPhones() {
        return mountDao.findAll();
    }
}
