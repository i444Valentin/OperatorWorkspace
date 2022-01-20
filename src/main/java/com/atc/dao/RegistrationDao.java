package com.atc.dao;

import com.atc.entity.RegistrationEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationDao {
    public RegistrationEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RegistrationEntity.class, number);
    }

    public void save(RegistrationEntity registration) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(registration);
        transaction.commit();
        session.close();
    }

    public void update(RegistrationEntity registration) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(registration);
        transaction.commit();
        session.close();
    }

    public void delete(RegistrationEntity registration) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(registration);
        transaction.commit();
        session.close();
    }

    public List<RegistrationEntity> findAll() {
        return (List<RegistrationEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM RegistrationEntity ").list();
    }
}
