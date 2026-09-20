package com.na.rutaexpress.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.rutaexpress.catalog.model.FleetCapacity;
import com.na.rutaexpress.catalog.repository.FleetCapacityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FleetCapacityService {

    @Autowired
    private FleetCapacityRepository fleetCapacityRepository;

    public List<FleetCapacity> findAll() {
        return fleetCapacityRepository.findAll();
    }

    public FleetCapacity findById(Long id) {
        return fleetCapacityRepository.findById(id).get();
    }

    public FleetCapacity save(FleetCapacity fleetCapacity) {
        return fleetCapacityRepository.save(fleetCapacity);
    }

    public FleetCapacity descontarCapacidad(String vehicleType) {
    FleetCapacity flota = fleetCapacityRepository.findByVehicleType(vehicleType)
        .orElseThrow(() -> new RuntimeException("Tipo de vehiculo no encontrado: " + vehicleType));

    if (flota.getCurrentAvailable() <= 0) {
        throw new RuntimeException("Sin capacidad disponible para: " + vehicleType);
    }

    flota.setCurrentAvailable(flota.getCurrentAvailable() - 1);
    return fleetCapacityRepository.save(flota);
    }
}