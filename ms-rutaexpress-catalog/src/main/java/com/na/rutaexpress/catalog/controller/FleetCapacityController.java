package com.na.rutaexpress.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.na.rutaexpress.catalog.model.FleetCapacity;
import com.na.rutaexpress.catalog.service.FleetCapacityService;

@RestController
@RequestMapping("/api/catalog/fleet-capacity")
public class FleetCapacityController {

    @Autowired
    private FleetCapacityService fleetCapacityService;

    @GetMapping
    public ResponseEntity<List<FleetCapacity>> listar() {
        List<FleetCapacity> flota = fleetCapacityService.findAll();
        if (flota.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flota);
    }

    @PostMapping
    public ResponseEntity<FleetCapacity> guardar(@RequestBody FleetCapacity fleetCapacity) {
        FleetCapacity nuevo = fleetCapacityService.save(fleetCapacity);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FleetCapacity> buscar(@PathVariable Long id) {
        try {
            FleetCapacity flota = fleetCapacityService.findById(id);
            return ResponseEntity.ok(flota);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{vehicleType}/descontar")
    public ResponseEntity<FleetCapacity> descontar(@PathVariable String vehicleType) {
        try {
            FleetCapacity flota = fleetCapacityService.descontarCapacidad(vehicleType);
            return ResponseEntity.ok(flota);
            } catch (RuntimeException e) {
            
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/{vehicleType}/reponer")
    public ResponseEntity<FleetCapacity> reponer(@PathVariable String vehicleType) {
        try {
        FleetCapacity flota = fleetCapacityService.reponerCapacidad(vehicleType);
        return ResponseEntity.ok(flota);
            } catch (RuntimeException e) {

            return ResponseEntity.notFound().build();
            }
    }
}