package com.java.jpa.demo.model;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 *
 * @author rahul
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", length = 15)
    @NotNull
    private String firstname;

    @Column(name = "lastname", length = 15)
    @NotNull
    private String lastname;

    @Column(name = "prefix", length = 5)
    private String prefix;

    @Column(name = "suffix", length = 10)
    private String suffix;

    @Column(name = "email", length = 40)
    @NotNull
    @Email
    private String email;

    @Column(name = "phone", length = 10)
    @NotNull
    @Min(value = 10)
    private String phone;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private Set addresses;
//
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    private Education education;

    public Student() {
    }

    public Student(String firstname, String lastname, String prefix, String suffix, String email, String phone, Address address, Education education) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.prefix = prefix;
        this.suffix = suffix;
        this.email = email;
        this.phone = phone;
        this.education = education;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
