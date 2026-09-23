package com.na.rutaexpress.catalog.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @Column(name = "popular")
    private Boolean popular;

    @Column(name = "weight_limit_kg")
    private Double weightLimitKg;

    @Column(name = "eta_window_label")
    private String etaWindowLabel;

    @Column(name = "sla_percent")
    private Integer slaPercent;

    @ElementCollection
    @CollectionTable(name = "service_coverage_cities", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "city")
    private List<String> coverageCities = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "service_features", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "feature")
    private List<String> features = new ArrayList<>();

public ServiceShipping(String name, String description, Integer price, Boolean active,
                            String vehicleTypeRequired, Boolean popular, Double weightLimitKg,
                            String etaWindowLabel, Integer slaPercent,
                            List<String> coverageCities, List<String> features) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.vehicleTypeRequired = vehicleTypeRequired;
        this.popular = popular;
        this.weightLimitKg = weightLimitKg;
        this.etaWindowLabel = etaWindowLabel;
        this.slaPercent = slaPercent;
        this.coverageCities = coverageCities != null ? coverageCities : new ArrayList<>();
        this.features = features != null ? features : new ArrayList<>();
    }
}