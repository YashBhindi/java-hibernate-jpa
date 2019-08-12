package com.java.jpa.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author yash
 */
//@Entity
//@Table(name = "address",schema="public")
@Embeddable
public class Address {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @Column(name = "street1", length = 20)
    @NotNull
    private String street1;

    @Column(name = "street2", length = 25)
    private String street2;

    @Column(name = "city", length = 15)
    @NotNull
    private String city;

    @Column(name = "state", length = 15)
    @NotNull
    private String state;

    @Column(name = "country", length = 15)
    @NotNull
    private String country;

    @Column(name = "zipcode", length = 6)
    @NotNull
    @Min(value = 6)
    private String zipcode;

    public Address(String street1, String street2, String city, String state, String country, String zipcode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

//    @OneToOne(mappedBy = "address")
//    private Student student;
//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;
    public Address() {
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
