package com.invillia;

import com.invillia.dao.TimesDAO;
import com.invillia.domain.Times;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("incubaria");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("-------------------------------------------------------");
        final TimesDAO timesDAO= new TimesDAO(entityManager);

        //timesDAO.insert(new Times("Incubaria"));

        System.out.println(timesDAO.findAll());
        final Times times = timesDAO.findById(5L);
        System.out.println(times);

        //times.setNome("Incubaria");

        //timesDAO.update(times);

        System.out.println(timesDAO.findById(5L));


        timesDAO.deleteFromId(5L);

    }


}
