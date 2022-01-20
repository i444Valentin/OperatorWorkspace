package com.atc.services;

import com.atc.dao.MountDao;
import com.atc.dao.TariffDao;
import com.atc.entity.MountsEntity;
import com.atc.entity.TariffsEntity;

import java.util.List;

public class TariffService {
    TariffDao tariffDao = new TariffDao();

    public TariffsEntity findTariff(int id) {
        return tariffDao.findById(id);

    }

    public void saveTariff(TariffsEntity tariff) {
        tariffDao.save(tariff);

    }

    public void updateTariff(TariffsEntity tariff) {
        tariffDao.update(tariff);

    }

    public void deleteTariff(TariffsEntity tariff) {
        tariffDao.delete(tariff);

    }

    public List<TariffsEntity> findAllTariffs() {
        return tariffDao.findAll();
    }
}
