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
@Table(name = "service_shipping")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class ServiceShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "price", nullable=false)
    private Integer price;

    @Column(name = "active", nullable=false)
    private Boolean active;

    @Column(name = "vehicle_type_required", nullable=false)
    private String vehicleTypeRequired;

    public ServiceShipping(String name, String description, Integer price, Boolean active, String vehicleTypeRequired) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.vehicleTypeRequired = vehicleTypeRequired;
    }
}
