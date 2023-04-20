package com.first.evaluation.entities;

import javax.persistence.*;

@Entity
@Table(name = "maintenance")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "numbervehicle")
    private Vehicle numbervehicle;

    @Column(name = "lastvidange_km")
    private Double lastvidangeKm;

    @Column(name = "lastpneu_km")
    private Double lastpneuKm;

    @Column(name = "nextvidange_km")
    private Double nextvidangeKm;

    @Column(name = "nextpneu_km")
    private Double nextpneuKm;

    public Double getNextpneuKm() {
        return nextpneuKm;
    }

    public void setNextpneuKm(Double nextpneuKm) {
        this.nextpneuKm = nextpneuKm;
    }

    public Double getNextvidangeKm() {
        return nextvidangeKm;
    }

    public void setNextvidangeKm(Double nextvidangeKm) {
        this.nextvidangeKm = nextvidangeKm;
    }

    public Double getLastpneuKm() {
        return lastpneuKm;
    }

    public void setLastpneuKm(Double lastpneuKm) {
        this.lastpneuKm = lastpneuKm;
    }

    public Double getLastvidangeKm() {
        return lastvidangeKm;
    }

    public void setLastvidangeKm(Double lastvidangeKm) {
        this.lastvidangeKm = lastvidangeKm;
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