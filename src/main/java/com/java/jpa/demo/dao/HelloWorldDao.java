/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.HelloWorld;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
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
        System.out.println("Enter message:");
        msg = sc.next();
        if (Objects.isNull(msg)) {
            System.out.println("Provide valid message..");
        } else {
            HelloWorld helloWorld = new HelloWorld(msg);
            entityManager.persist(helloWorld);
            entityManager.getTransaction().commit();
            System.out.println("Message added..");
        }
    }

    public void getAllMessages() {
        //retrieve data'
        Query query = entityManager.createQuery("SELECT m FROM HelloWorld m", HelloWorld.class);
        List<HelloWorld> message = query.getResultList();
        for (HelloWorld m : message) {
            System.out.println("Message:" + m.getMessage());
        }

    }

    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
