package com.atc.dao;

import com.atc.entity.OperatorsEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OperatorDao {
    public OperatorsEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OperatorsEntity.class, number);
    }

    public void save(OperatorsEntity operator) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(operator);
        transaction.commit();
        session.close();
    }

    public void update(OperatorsEntity operator) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(operator);
        transaction.commit();
        session.close();
    }

    public void delete(OperatorsEntity operator) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(operator);
        transaction.commit();
        session.close();
    }

    public List<OperatorsEntity> findAll() {
        return (List<OperatorsEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM OperatorsEntity ").list();
    }
}
