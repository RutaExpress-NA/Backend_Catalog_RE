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

    @Column(name = "vehicle_type", unique = true, nullable = false)
    private String vehicleType;
    
    @Column(name = "total_capacity", nullable=false)
    private Integer totalCapacity;

    @Column(name = "current_available", nullable=false)
    private Integer currentAvailable;

    public FleetCapacity(String vehicleType, Integer totalCapacity, Integer currentAvailable) {
        this.vehicleType = vehicleType;
        this.totalCapacity = totalCapacity;
        this.currentAvailable = currentAvailable;
    }
}
