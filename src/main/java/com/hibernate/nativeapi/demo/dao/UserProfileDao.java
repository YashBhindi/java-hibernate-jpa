/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.nativeapi.demo.dao;

import com.hibernate.nativeapi.demo.config.HibernateUtil;
import com.hibernate.nativeapi.demo.model.HelloWorld;
import com.hibernate.nativeapi.demo.model.UserProfile;
import java.util.List;
import java.util.Objects;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author yash
 */
public class UserProfileDao {
     public void saveUser(UserProfile userProfile) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the hello world object
            session.save(userProfile);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List < UserProfile > getUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from UserProfile", UserProfile.class).list();
        }
    }
}
