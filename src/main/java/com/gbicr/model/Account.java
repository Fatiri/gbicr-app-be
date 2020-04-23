package com.gbicr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "account")
public class Account {

    public Account(String id, String full_name, String email, String username, String password, String phone_number, String birthdate, String birthplace) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
    }

    public Account() {
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column
    @NotEmpty(message = "Please provide a name")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String full_name;

    @Column
    @NotEmpty
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
    @NotNull
    private String email;

    @Column
    @NotEmpty(message = "Please provide a username")
    @Size(min = 5, message = "Please provide a username at least 5 characters")
    private String username;

    @Column
    @NotEmpty(message = "Please provide a password")
    @Size(min = 8, message = "Please provide a password at least 8 characters")
    private String password;

    @Column
    @NotEmpty(message = "Please provide a phone number")
    @Size(min = 10, message = "Please provide a phone number at least 10 characters")
    private String phone_number;

    @Column
    @NotEmpty(message = "Please provide a birthdate")
    private String birthdate;

    @Column
    @NotEmpty(message = "Please provide a birthplace")
    private String birthplace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
