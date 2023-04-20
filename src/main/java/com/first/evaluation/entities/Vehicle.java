package com.first.evaluation.entities;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "number", nullable = false, length = 7)
    private String id;

    @ManyToOne
    @JoinColumn(name = "idtype")
    private Type idtype;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "km")
    private Double km;

    public Vehicle() {
    }


    public Vehicle(String id, Type idtype, String mark, String model, Double km) {
        this.id = id;
        this.idtype = idtype;
        this.mark = mark;
        this.model = model;
        this.km = km;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Type getIdtype() {
        return idtype;
    }

    public void setIdtype(Type idtype) {
        this.idtype = idtype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}