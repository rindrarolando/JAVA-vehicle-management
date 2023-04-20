package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assurance")
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "numbervehicle")
    private Vehicle numbervehicle;

    @Column(name = "last_date_of_payment")
    private LocalDate lastDateOfPayment;

    @Column(name = "expiration")
    private LocalDate expiration;

    public Assurance() {
    }

    public Assurance(Vehicle numbervehicle, LocalDate lastDateOfPayment, LocalDate expiration) {
        this.numbervehicle = numbervehicle;
        this.lastDateOfPayment = lastDateOfPayment;
        this.expiration = expiration;
    }

    public Assurance(Integer id, Vehicle numbervehicle, LocalDate lastDateOfPayment, LocalDate expiration) {
        this.id = id;
        this.numbervehicle = numbervehicle;
        this.lastDateOfPayment = lastDateOfPayment;
        this.expiration = expiration;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public LocalDate getLastDateOfPayment() {
        return lastDateOfPayment;
    }

    public void setLastDateOfPayment(LocalDate lastDateOfPayment) {
        this.lastDateOfPayment = lastDateOfPayment;
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