/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.Personnel;
import com.java.jpa.demo.model.Proposal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author yash
 */
public class EntityTransactionCrud {

    private static final Logger LOGGER = Logger.getLogger(EntityTransactionCrud.class.getName());
    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;
    static EntityTransaction entityTransaction;
    static Scanner sc;

    public EntityTransactionCrud() {
        entityManagerFactory = Persistence.createEntityManagerFactory("per");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        sc = new Scanner(System.in);
    }

    public void save(Object object) {
        entityManager.persist(object);
        entityManager.getTransaction().commit();
    }

    public void update(Object newObject) {
        entityManager.merge(newObject);
        entityManager.getTransaction().commit();
    }

    public List<? extends Object> getAll(String entityClass) {
        List<? extends Object> objects = null;
        try {
            objects = entityManager.createQuery(
                    "SELECT p FROM " + entityClass + " p").getResultList();
        } catch (Exception exception) {
            LOGGER.info("Class not found." + exception);
        }
        return objects;
    }

    public Object findByUniqueColumnValue(String entityClass, String column, String columnValue) throws ClassNotFoundException {
        TypedQuery<? extends Object> query = entityManager.createQuery(
                "SELECT c FROM " + entityClass + " c WHERE c." + column + "name = :name", Class.forName(entityClass));
        return query.setParameter(column, columnValue).getSingleResult();
    }

    public void delete(String entityClass, int rowId) {
        try {
            String str = "DELETE FROM " + entityClass + " asd WHERE asd.id = " + rowId;
            LOGGER.info(str);
            Query query = entityManager
                    .createQuery(str);
            int deletionCount = query.executeUpdate();
            if (deletionCount > 0) {
                LOGGER.info("Entry deleted.");
            } else {
                LOGGER.info("Entry not found.");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            LOGGER.info("Class not found.");
        }
    }
}
