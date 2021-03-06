package com.atc.dao;

import com.atc.entity.AbonentsEntity;
import com.atc.entity.OperatorAccountsEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class OperatorAccountDao {
    public OperatorAccountsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OperatorAccountsEntity.class, id);
    }

    public OperatorAccountsEntity findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();


        OperatorAccountsEntity result = (OperatorAccountsEntity) session
                .createQuery("from OperatorAccountsEntity o where o.login= :login")
                .setParameter("login", login).uniqueResult();
        return result;
    }

//    public void save(OperatorAccountsEntity opAccount) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(opAccount);
//        transaction.commit();
//        session.close();
//    }

//    public void update(OperatorAccountsEntity opAccount) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(opAccount);
//        transaction.commit();
//        session.close();
//    }

//    public void delete(OperatorAccountsEntity opAccount) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(opAccount);
//        transaction.commit();
//        session.close();
//    }

    public List<OperatorAccountsEntity> findAll() {
        return (List<OperatorAccountsEntity>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession();
    }

}
