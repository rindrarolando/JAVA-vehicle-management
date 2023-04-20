package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "arrival")
public class Arrival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iddeparture")
    private Departure iddeparture;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "arrival_place")
    private String arrivalPlace;

    @Column(name = "arrival_km")
    private Double arrivalKm;

    public Arrival() {
    }

    public Arrival(Integer id, Departure iddeparture, LocalDateTime arrivalTime, String arrivalPlace, Double arrivalKm) {
        this.id = id;
        this.iddeparture = iddeparture;
        this.arrivalTime = arrivalTime;
        this.arrivalPlace = arrivalPlace;
        this.arrivalKm = arrivalKm;
    }

    public Double getArrivalKm() {
        return arrivalKm;
    }

    public void setArrivalKm(Double arrivalKm) {
        this.arrivalKm = arrivalKm;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Departure getIddeparture() {
        return iddeparture;
    }

    public void setIddeparture(Departure iddeparture) {
        this.iddeparture = iddeparture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}