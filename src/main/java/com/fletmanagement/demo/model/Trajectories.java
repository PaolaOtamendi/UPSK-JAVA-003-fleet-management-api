package com.fletmanagement.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trajectories")
public class Trajectories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "taxi_id")
    private Integer taxiId;

    @Column(name = "date")
    private LocalDateTime date;
    private Double latitude;
    private Double longitude;

    public Trajectories() {
    }

    public Long getId() {
        return  id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }
}
