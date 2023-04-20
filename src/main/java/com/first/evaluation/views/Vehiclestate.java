package com.first.evaluation.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "vehiclestate")
public class Vehiclestate {
    @Id
    @Column(name = "number", length = 7)
    private String number;

    @Column(name = "km")
    private Double km;

    @Column(name = "assurance_id")
    private Integer assuranceId;

    @Column(name = "last_date_of_payment")
    private LocalDate lastDateOfPayment;

    @Column(name = "expiration")
    private LocalDate expiration;

    @Column(name = "visite_id")
    private Integer visiteId;

    @Column(name = "last_visit")
    private LocalDate lastVisit;

    @Column(name = "next_visit")
    private LocalDate nextVisit;

    @Column(name = "lastvidange_km")
    private Double lastvidangeKm;

    @Column(name = "nextvidange_km")
    private Double nextvidangeKm;

    @Column(name = "lastpneu_km")
    private Double lastpneuKm;

    @Column(name = "nextpneu_km")
    private Double nextpneuKm;

    public Double getNextpneuKm() {
        return nextpneuKm;
    }

    public Double getLastpneuKm() {
        return lastpneuKm;
    }

    public Double getNextvidangeKm() {
        return nextvidangeKm;
    }

    public Double getLastvidangeKm() {
        return lastvidangeKm;
    }

    public LocalDate getNextVisit() {
        return nextVisit;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public Integer getVisiteId() {
        return visiteId;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public LocalDate getLastDateOfPayment() {
        return lastDateOfPayment;
    }

    public Integer getAssuranceId() {
        return assuranceId;
    }

    public Double getKm() {
        return km;
    }

    public String getNumber() {
        return number;
    }
}