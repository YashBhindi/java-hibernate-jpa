package com.java.jpa.demo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author yash
 */
@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "filename", length = 20)
    @NotNull
    private String filename;

    @Column(name = "filesize", length = 10)
    @NotNull
    private String filesize;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "attachment")
    @NotNull
    private byte[] attachment;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.filename);
        hash = 23 * hash + Objects.hashCode(this.filesize);
        hash = 23 * hash + Objects.hashCode(this.created);
        hash = 23 * hash + Arrays.hashCode(this.attachment);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attachment other = (Attachment) obj;
        if (!Objects.equals(this.filename, other.filename)) {
            return false;
        }
        if (!Objects.equals(this.filesize, other.filesize)) {
            return false;
        }
        if (!Objects.equals(this.created, other.created)) {
            return false;
        }
        if (!Arrays.equals(this.attachment, other.attachment)) {
            return false;
        }
        return true;
    }

    

  

    public Attachment() {
    }

    public Attachment(String filename, String filesize, LocalDateTime created, byte[] attachment) {
        this.filename = filename;
        this.filesize = filesize;
        this.created = created;
        this.attachment = attachment;
    }
}