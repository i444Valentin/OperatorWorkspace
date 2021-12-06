package com.atc.dao;

import com.atc.entity.AbonentsEntity;

import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class AbonentDao{

    public AbonentsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AbonentsEntity.class, id);
    }

    public void save(AbonentsEntity abonent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(abonent);
        transaction.commit();
        session.close();
    }

    public void update(AbonentsEntity abonent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(abonent);
        transaction.commit();
        session.close();
    }

    public void delete(AbonentsEntity abonent) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(abonent);
        transaction.commit();
        session.close();
    }

    public List<AbonentsEntity> findAll() {
        return (List<AbonentsEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("From AbonentsEntity").list();
    }
}
