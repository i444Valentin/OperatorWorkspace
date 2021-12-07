package com.atc.dao;

import com.atc.entity.MountsEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MountDao {
    public MountsEntity findById(int number) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(MountsEntity.class, number);
    }

    public void save(MountsEntity mount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mount);
        transaction.commit();
        session.close();
    }

    public void update(MountsEntity mount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(mount);
        transaction.commit();
        session.close();
    }

    public void delete(MountsEntity mount) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(mount);
        transaction.commit();
        session.close();
    }

    public List<MountsEntity> findAll() {
        return (List<MountsEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM MountsEntity ").list();
    }
}
