package com.atc.dao;

import com.atc.entity.TariffsEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TariffDao {
    public TariffsEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TariffsEntity.class, number);
    }

    public void save(TariffsEntity tariff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tariff);
        transaction.commit();
        session.close();
    }

    public void update(TariffsEntity tariff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(tariff);
        transaction.commit();
        session.close();
    }

    public void delete(TariffsEntity tariff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(tariff);
        transaction.commit();
        session.close();
    }

    public List<TariffsEntity> findAll() {
        return (List<TariffsEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM PhonesEntity ").list();
    }
}
