package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.CompositeKey;
import com.java.jpa.demo.model.HelloWorld;
import com.java.jpa.demo.model.UserProfile;
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
public class UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;
    Scanner sc;

    public UserDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("per");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        sc = new Scanner(System.in);
    }

    public void addUser() {
        String name = new String();
        String email = new String();
        Long phone;
        LOGGER.info("Enter user detail:");
        LOGGER.info("Enter name:");
        name = sc.next();
        LOGGER.info("Enter phone:");
        phone = sc.nextLong();
        LOGGER.info("Enter email:");
        email = sc.next();

        if (Objects.isNull(name) || Objects.isNull(email) || Objects.isNull(phone)) {
            LOGGER.info("Provide valid details..");
        } else {
            CompositeKey ck = new CompositeKey(name, phone);
            UserProfile up = new UserProfile(ck, email);
            entityManager.persist(up);
            entityManager.getTransaction().commit();
            LOGGER.info("Message added..");
        }

    }

    public void getAllUser() {
        //retrieve data'
        Query query = entityManager.createQuery("SELECT m FROM UserProfile m", UserProfile.class);
        List<UserProfile> users = query.getResultList();
        users.stream().map((up) -> up.toString());
    }

    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
