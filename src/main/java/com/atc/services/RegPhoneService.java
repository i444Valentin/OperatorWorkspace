package com.atc.services;

import com.atc.dao.RegistrationDao;
import com.atc.entity.RegistrationEntity;

import java.util.List;

public class RegPhoneService {
    RegistrationDao registrationDao = new RegistrationDao();

    public RegistrationEntity findRegistration(int id) {
        return registrationDao.findById(id);

    }

    public void saveRegistration(RegistrationEntity registration) {
        registrationDao.save(registration);

    }

    public void updateRegistration(RegistrationEntity registration) {
        registrationDao.update(registration);

    }

    public void deleteRegistration(RegistrationEntity registration) {
        registrationDao.delete(registration);

    }

    public List<RegistrationEntity> findAllRegistrations() {
        return registrationDao.findAll();
    }
}
