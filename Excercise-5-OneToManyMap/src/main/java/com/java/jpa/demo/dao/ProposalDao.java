package com.java.jpa.demo.dao;

import com.java.jpa.demo.model.Attachment;
import com.java.jpa.demo.model.Personnel;
import com.java.jpa.demo.model.Proposal;
import com.java.jpa.demo.model.QualificationLevel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author yash
 */
public class ProposalDao implements BaseDao {

    private static final Logger LOGGER = Logger.getLogger(ProposalDao.class.getName());

    EntityTransactionCrud entityTransactionCrud;
    Scanner sc;

    public ProposalDao() {

        sc = new Scanner(System.in);
        entityTransactionCrud = new EntityTransactionCrud();
    }

    public Personnel getPersonnelDataFromUser() {
        LOGGER.info("Enter name:");
        String name = sc.next();
        LOGGER.info("Select Qualification level from below:");
        LOGGER.info("1 for beginner:");
        LOGGER.info("2 for Intermediate :");
        LOGGER.info("3 for Pro:");
        int index = sc.nextInt();
        LOGGER.info("Enter phone number:");
        String phone = sc.next();
        return new Personnel(name, QualificationLevel.valueOf(index).get(), phone);
    }

    public Attachment getAttachmentDataFromUser() {
        LOGGER.info("Enter file name:");
        String fileName = sc.next();
        LOGGER.info("Enter file size:");
        String fileSize = sc.next();
        return new Attachment(fileName, fileSize, LocalDateTime.now(), fileName.getBytes());

    }

    @Override
    public void add() {
        List<Personnel> per = new ArrayList<>();
        List<Attachment> att = new ArrayList<>();
        LOGGER.info("Enter numnber of personnel for this proposal");
        int noOfPersonnel = sc.nextInt();
        for (int i = 0; i < noOfPersonnel; i++) {
            per.add(getPersonnelDataFromUser());
        }
        LOGGER.info("Enter numnber of Attachment for this proposal");
        int noOfAttachment = sc.nextInt();
        for (int i = 0; i < noOfAttachment; i++) {
            att.add(getAttachmentDataFromUser());
        }

        LOGGER.info("Enter title:");
        String title = sc.next();
        LOGGER.info("Enter comment:");
        String comment = sc.next();
        Proposal proposal = new Proposal(title, comment, per, att);
        entityTransactionCrud.save(proposal);
        LOGGER.info("Proposal added..");
    }

    @Override
    public void delete() {
        LOGGER.info("Enter proposal row id:");
        int rowId = sc.nextInt();
        entityTransactionCrud.delete("Proposal",rowId);
        LOGGER.info("Proposal deleted..");
    }

    @Override
    public void update() {
        LOGGER.info("Enter proposal row id:");
        int rowId=sc.nextInt();
        
        List<Personnel> per = new ArrayList<>();
        List<Attachment> att = new ArrayList<>();
        LOGGER.info("Enter numnber of personnel for this proposal");
        int noOfPersonnel = sc.nextInt();
        for (int i = 0; i < noOfPersonnel; i++) {
            per.add(getPersonnelDataFromUser());
        }
        LOGGER.info("Enter numnber of Attachment for this proposal");
        int noOfAttachment = sc.nextInt();
        for (int i = 0; i < noOfAttachment; i++) {
            att.add(getAttachmentDataFromUser());
        }

        LOGGER.info("Enter title:");
        String title = sc.next();
        LOGGER.info("Enter comment:");
        String comment = sc.next();
        Proposal proposal = new Proposal(title, comment, per, att);
        proposal.setId(rowId);
        entityTransactionCrud.update(proposal);
        LOGGER.info("Proposal updated..");
    }

    @Override
    public void getAll() {
        List<Proposal> objects = (List<Proposal>) entityTransactionCrud.getAll("Proposal");
        objects.stream().map(ob -> ob.toString());
    }
}
