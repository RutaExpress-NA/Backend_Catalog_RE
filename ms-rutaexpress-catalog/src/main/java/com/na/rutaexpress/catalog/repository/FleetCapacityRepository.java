package com.na.rutaexpress.catalog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.na.rutaexpress.catalog.model.FleetCapacity;

public interface FleetCapacityRepository extends JpaRepository<FleetCapacity, Long> {

    Optional<FleetCapacity> findByVehicleType(String vehicleType);
}