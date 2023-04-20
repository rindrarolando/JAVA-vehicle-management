package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "departure")
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "numbervehicle")
    private Vehicle numbervehicle;

    @ManyToOne
    @JoinColumn(name = "iddriver")
    private Driver iddriver;

    @Column(name = "motif")
    private String motif;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "departure_place")
    private String departurePlace;

    @Column(name = "departure_km")
    private Double departureKm;

    @Column(name = "fuel_price")
    private Double fuelPrice;

    @Column(name = "fuel_quantity")
    private Double fuelQuantity;

    public Departure() {
    }

    public Departure(Integer id, Vehicle numbervehicle, Driver iddriver, String motif, LocalDateTime departureTime, String departurePlace, Double departureKm, Double fuelPrice, Double fuelQuantity) {
        this.id = id;
        this.numbervehicle = numbervehicle;
        this.iddriver = iddriver;
        this.motif = motif;
        this.departureTime = departureTime;
        this.departurePlace = departurePlace;
        this.departureKm = departureKm;
        this.fuelPrice = fuelPrice;
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(Double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public Double getDepartureKm() {
        return departureKm;
    }

    public void setDepartureKm(Double departureKm) {
        this.departureKm = departureKm;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Driver getIddriver() {
        return iddriver;
    }

    public void setIddriver(Driver iddriver) {
        this.iddriver = iddriver;
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