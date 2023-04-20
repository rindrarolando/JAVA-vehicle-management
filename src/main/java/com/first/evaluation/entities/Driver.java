package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "login")
    private String login;

    public Driver() {
    }

    public Driver(Integer id, String name, String password, LocalDate birth, String login) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}