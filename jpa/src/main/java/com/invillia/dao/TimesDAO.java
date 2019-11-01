package com.invillia.dao;

import com.invillia.domain.Times;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

// data access object
public class TimesDAO {

    private final EntityManager entityManager;

    public TimesDAO(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(final Times times) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(times);
        transaction.commit();
    }

    public List<Times> findAll() {
        final TypedQuery<Times> times = entityManager.createQuery(
                "from Times",
                Times.class
        );
        return times.getResultList();
    }

    public Times findById(final Long id) {
        return entityManager.find(Times.class, id);
    }

    public void update(final Times times) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(times);
        transaction.commit();
    }

    public void deleteFromId(final Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Times times = findById(id);
        entityManager.remove(times);
        transaction.commit();
    }
}
