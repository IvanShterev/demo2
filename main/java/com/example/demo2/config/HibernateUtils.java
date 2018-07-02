package com.example.demo2.config;

import com.example.demo2.entities.Friend;
import com.example.demo2.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    static SessionFactory sessionFactory;

    static {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
                .configure();

        configuration.addAnnotatedClass(Friend.class);
        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(User.class);

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        serviceRegistryBuilder.applySettings(configuration.getProperties());
        StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
