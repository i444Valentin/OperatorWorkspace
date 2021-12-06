package com.atc.utils;

import com.atc.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AbonentsEntity.class);
                configuration.addAnnotatedClass(MountsEntity.class);
                configuration.addAnnotatedClass(OperatorAccountsEntity.class);
                configuration.addAnnotatedClass(OperatorsEntity.class);
                configuration.addAnnotatedClass(PhonesEntity.class);
                configuration.addAnnotatedClass(PhoneTypesEntity.class);
                configuration.addAnnotatedClass(RegistrationEntity.class);
                configuration.addAnnotatedClass(TariffsEntity.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return sessionFactory;
    }
}
