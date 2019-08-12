package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.HelloWorld;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author yash
 */
public class HelloWorldDao {

    private static final Logger LOGGER = Logger.getLogger(HelloWorldDao.class.getName());
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;
    Scanner sc;

    public HelloWorldDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("per");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        sc = new Scanner(System.in);
    }

    public void addMessage() {
        String msg = new String();
        LOGGER.info("Enter message:");
        msg = sc.next();
        if (Objects.isNull(msg)) {
            LOGGER.info("Provide valid message..");
        } else {
            HelloWorld helloWorld = new HelloWorld(msg);
            entityManager.persist(helloWorld);
            entityManager.getTransaction().commit();
            LOGGER.info("Message added..");
        }
    }

    public void getAllMessages() {
        //retrieve data'
        Query query = entityManager.createQuery("SELECT m FROM HelloWorld m", HelloWorld.class);
        List<HelloWorld> message = query.getResultList();
        message.stream().map((up) -> up.toString());

    }

    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
