package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.*;
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
public class StudentDao {

    private static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;
    Scanner sc;

    public StudentDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("per");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        sc = new Scanner(System.in);
    }

    public void addStudent() {

        Education education = new Education("B.Tech", "IT", "2019", "charusat");
        Address address1 = new Address("laxmi-nivas", "setawad", "jamnagar", "Gujarat", "India", "361001");
        Student st = new Student("yash", "bhindi", "", "", "yash@gmail.com", "90993234", address1, education);

        Address address2 = new Address("suryanarayan society", "sector-25", "Gandhinagar", "Gujarat", "India", "388120");

        entityManager.persist(st);
        entityManager.getTransaction().commit();
        LOGGER.info("Student added..");

    }

    public void getAllStudent() {
        //retrieve data'
        Query query = entityManager.createQuery("SELECT m FROM Student m", Student.class);
        List<Student> students = query.getResultList();
        students.stream().map( (st) ->  st.toString());
    }

    public void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
