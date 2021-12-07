package com.atc.dao;

import com.atc.entity.AbonentsEntity;
import com.atc.entity.PhonesEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PhoneDao {
    public AbonentsEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AbonentsEntity.class, number);
    }

    public void save(PhonesEntity phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(phone);
        transaction.commit();
        session.close();
    }

    public void update(PhonesEntity phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(phone);
        transaction.commit();
        session.close();
    }

    public void delete(PhonesEntity phone) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(phone);
        transaction.commit();
        session.close();
    }

    public List<PhonesEntity> findAll() {
        return (List<PhonesEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM PhonesEntity ").list();
    }
}
