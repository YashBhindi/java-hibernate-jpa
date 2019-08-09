/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.jpa.demo.driver;

/**
 *
 * @author yash
 */
import com.java.jpa.demo.dao.HelloWorldDao;
import com.java.jpa.demo.dao.UserDao;
import com.java.jpa.demo.model.CompositeKey;
import com.java.jpa.demo.model.HelloWorld;
import com.java.jpa.demo.model.UserProfile;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Driver {

    public static void main(String[] args) {

        HelloWorldDao helloWorldDao = new HelloWorldDao();
        UserDao userDao = new UserDao();
        Scanner sc =  new Scanner(System.in);
        //getInputsForMessage(helloWorldDao, sc);
        getInputsForUserProfile(userDao, sc);
        System.out.println("Outside");
    }

    public static void getInputsForMessage(HelloWorldDao helloWorldDao, Scanner sc) {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the choice:");
            System.out.println("1 to add message:");
            System.out.println("2 to real all message:");
            System.out.println("3 to exit:");

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    helloWorldDao.addMessage();
                    break;
                case 2:
                    helloWorldDao.getAllMessages();
                    break;
                case 3:
                    flag = false;
                    helloWorldDao.closeConnection();
                    break;
            }

        }
    }

    public static void getInputsForUserProfile(UserDao userDao, Scanner sc) {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the choice:");
            System.out.println("1 to add user:");
            System.out.println("2 to get all user:");
            System.out.println("3 to exit:");

            int n = sc.nextInt();
            switch (n) {
                case 1:
                    userDao.addUser();
                    break;
                case 2:
                    userDao.getAllUser();
                    break;
                case 3:
                    flag = false;
                    userDao.closeConnection();
                    break;
            }

        }
        System.out.println("fun");
    }

}
