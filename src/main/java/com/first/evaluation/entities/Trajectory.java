package com.first.evaluation.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trajectory")
public class Trajectory {
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
    private Instant departureTime;

    @Column(name = "departure_place")
    private String departurePlace;

    @Column(name = "departure_km")
    private Double departureKm;

    @Column(name = "arrival_time")
    private Instant arrivalTime;

    @Column(name = "arrival_place")
    private String arrivalPlace;

    @Column(name = "arrival_km")
    private Double arrivalKm;

    @Column(name = "fuel_price")
    private Double fuelPrice;

    @Column(name = "fuel_quantity")
    private Double fuelQuantity;

    @Column(name = "status")
    private Boolean status;

    public Trajectory() {
    }

    public Trajectory(Integer id, Vehicle numbervehicle, Driver iddriver, String motif, Instant departureTime, String departurePlace, Double departureKm, Instant arrivalTime, String arrivalPlace, Double arrivalKm, Double fuelPrice, Double fuelQuantity, Boolean status) {
        this.id = id;
        this.numbervehicle = numbervehicle;
        this.iddriver = iddriver;
        this.motif = motif;
        this.departureTime = departureTime;
        this.departurePlace = departurePlace;
        this.departureKm = departureKm;
        this.arrivalTime = arrivalTime;
        this.arrivalPlace = arrivalPlace;
        this.arrivalKm = arrivalKm;
        this.fuelPrice = fuelPrice;
        this.fuelQuantity = fuelQuantity;
        this.status = status;
    }

    public Trajectory(Vehicle numbervehicle, Driver iddriver, String motif, Instant departureTime, String departurePlace, Double departureKm, Double fuelPrice, Double fuelQuantity, Boolean status) {
        this.numbervehicle = numbervehicle;
        this.iddriver = iddriver;
        this.motif = motif;
        this.departureTime = departureTime;
        this.departurePlace = departurePlace;
        this.departureKm = departureKm;
        this.fuelPrice = fuelPrice;
        this.fuelQuantity = fuelQuantity;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public Instant getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Instant departureTime) {
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