package com.atc.dao;

import com.atc.entity.PhoneTypesEntity;
import com.atc.entity.PhonesEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PhoneTypeDao {
    public PhoneTypesEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PhoneTypesEntity.class, number);
    }

    public void save(PhonesEntity phonetype) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(phonetype);
        transaction.commit();
        session.close();
    }

    public void update(PhonesEntity phonetype) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(phonetype);
        transaction.commit();
        session.close();
    }

    public void delete(PhonesEntity phonetype) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(phonetype);
        transaction.commit();
        session.close();
    }

    public List<PhonesEntity> findAll() {
        return (List<PhonesEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM PhonesEntity ").list();
    }
}
