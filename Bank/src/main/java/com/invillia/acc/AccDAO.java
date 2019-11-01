package com.invillia.acc;//import com.invillia.acc.Acount;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccDAO {
    private final EntityManager entityManager;

    public AccDAO(final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void insert(final Acount acc){
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(acc);
        transaction.commit();
    }

    public List<Acount> findAll() {
        final TypedQuery<Acount> acount = entityManager.createQuery(
                "from Acount",
                Acount.class
        );
        return acount.getResultList();
    }

    public Acount findById(final Long id) {
        return entityManager.find(Acount.class, id);
    }

    public void update(final Acount acount) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(acount);
        transaction.commit();
    }

    public void deleteById(final Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Acount acount = findById(id);
        entityManager.remove(acount);
        transaction.commit();
    }
}
