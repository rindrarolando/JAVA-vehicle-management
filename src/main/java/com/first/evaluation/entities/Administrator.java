package com.first.evaluation.entities;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", length = 50)
    private String login;

    @Column(name = "password")
    private String password;

    public Administrator(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Administrator() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}