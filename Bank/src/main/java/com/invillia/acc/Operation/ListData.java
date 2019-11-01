package com.invillia.acc.Operation;

import com.invillia.acc.AccDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;

public class ListData {
    public static void main() {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        final AccDAO accDAO = new AccDAO(entityManager);
        JOptionPane.showMessageDialog(null, accDAO.findAll());
    }
}
