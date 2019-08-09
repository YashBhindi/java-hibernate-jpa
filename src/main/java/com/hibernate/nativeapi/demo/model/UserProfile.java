/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.nativeapi.demo.model;

/**
 *
 * @author yash
 */
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    
   
    @Column(name = "id")
    private int id;

    @EmbeddedId
    private CompositeKey compositeKey;

    @Column(name = "email")
    private String email;

    public UserProfile(CompositeKey compositeKey, String email) {
        this.compositeKey = compositeKey;
        this.email = email;
    }

    public UserProfile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
