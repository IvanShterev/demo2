package com.example.demo2.repositories;

import com.example.demo2.config.HibernateUtils;
import com.example.demo2.entities.base.ModelEntity;
import com.example.demo2.repositories.base.GenericRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HibernateRepository<T extends ModelEntity> implements GenericRepository<T> {
    private final SessionFactory sessionFactory;
    private Class<T> entityClass;


    public HibernateRepository(Class<T> entityClass) {
        this.sessionFactory = HibernateUtils.getSessionFactory();
        this.entityClass = entityClass;
    }

    @Override
    public List<T> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());
        criteriaQuery.from(getEntityClass());

        List<T> entities = session.createQuery(criteriaQuery)
                .getResultList();

        transaction.commit();
        session.close();

        return entities;
    }

    @Override
    public T getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = builder.createQuery(getEntityClass());

        T entity = session.get(getEntityClass(), id);

        transaction.commit();
        session.close();

        return entity;
    }

    @Override
    public T create(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session
                .save(entity);

        transaction.commit();
        session.close();
        return entity;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}