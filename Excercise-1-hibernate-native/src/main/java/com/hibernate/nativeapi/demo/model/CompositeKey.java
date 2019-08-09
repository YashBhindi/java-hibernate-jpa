/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.nativeapi.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author yash
 */
@Embeddable
public class CompositeKey implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private Long phone;

    public CompositeKey(String name, Long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public CompositeKey() {
    }

}
