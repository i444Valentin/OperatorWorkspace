package com.atc.dao;

import com.atc.entity.AbonentsEntity;

import com.atc.entity.OperatorAccountsEntity;
import com.atc.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class AbonentDao{

    public AbonentsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(AbonentsEntity.class, id);
    }

    public List<AbonentsEntity> findByInicials(String firstName,String lastName,String patronymic){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        @SuppressWarnings("unchecked")
        List<AbonentsEntity> result = (List<AbonentsEntity>) session
                .createQuery("from AbonentsEntity o where o.имя LIKE ?0 and o.фамилия like ?1 and o.отчество like ?2")
                .setParameter(0, "%"+firstName+"%")
                .setParameter(1,"%"+lastName+"%")
                .setParameter(2,"%"+patronymic+"%")
                .list();
        return result;
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
    @SuppressWarnings("unchecked")
    public List<AbonentsEntity> findAll() {
        return (List<AbonentsEntity>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession()
                .createQuery("FROM AbonentsEntity").list();
    }
}
