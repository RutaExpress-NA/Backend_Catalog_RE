package com.na.rutaexpress.catalog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fleet_capacity")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class FleetCapacity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vehicleType;
    
    @Column(nullable=false)
    private Integer totalCapacity;

    @Column(nullable=false)
    private Integer currentlyAvailable;

    public FleetCapacity(String vehicleType, Integer totalCapacity, Integer currentlyAvailable) {
        this.vehicleType = vehicleType;
        this.totalCapacity = totalCapacity;
        this.currentlyAvailable = currentlyAvailable;
    }
}
