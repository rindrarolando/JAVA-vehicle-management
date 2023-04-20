package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visite")
public class Visite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "numbervehicle")
    private Vehicle numbervehicle;

    @Column(name = "last_visit")
    private LocalDate lastVisit;

    @Column(name = "next_visit")
    private LocalDate nextVisit;

    public Visite() {
    }

    public Visite(Integer id, Vehicle numbervehicle, LocalDate lastVisit, LocalDate nextVisit) {
        this.id = id;
        this.numbervehicle = numbervehicle;
        this.lastVisit = lastVisit;
        this.nextVisit = nextVisit;
    }

    public Visite(Vehicle numbervehicle, LocalDate lastVisit, LocalDate nextVisit) {
        this.numbervehicle = numbervehicle;
        this.lastVisit = lastVisit;
        this.nextVisit = nextVisit;
    }

    public LocalDate getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(LocalDate nextVisit) {
        this.nextVisit = nextVisit;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Vehicle getNumbervehicle() {
        return numbervehicle;
    }

    public void setNumbervehicle(Vehicle numbervehicle) {
        this.numbervehicle = numbervehicle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}