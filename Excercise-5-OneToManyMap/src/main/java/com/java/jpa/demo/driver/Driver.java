package com.java.jpa.demo.driver;

/**
 *
 * @author yash
 */
import com.java.jpa.demo.dao.AttachmentDao;
import com.java.jpa.demo.dao.BaseDao;
import com.java.jpa.demo.dao.PersonnelDao;
import com.java.jpa.demo.dao.ProposalDao;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Driver {

    private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {

        BaseDao baseDao = null;
        baseDao = getClassInfo(baseDao, args[0]);
        getOperation(baseDao, args[1]);

    }

    public static BaseDao getClassInfo(BaseDao baseDao, String daoClass) {
        switch (daoClass) {
            case "proposal":
                baseDao = new ProposalDao();
                break;
            case "personnel":
                baseDao = new PersonnelDao();
                break;
            case "attachment":
                baseDao = new AttachmentDao();
                break;
            default:
                LOGGER.info("Invalid Input..");
                break;
        }
        return baseDao;
    }

    public static void getOperation(BaseDao obj, String opetaion) {
        switch (opetaion) {
            case "insert":
                obj.add();
                break;
            case "update":
                obj.update();
                break;
            case "delete":
                obj.delete();
                break;
            case "retrive":
                obj.getAll();
                break;
            default:
                LOGGER.info("Invalid Input..");
                break;
        }
    }

}
