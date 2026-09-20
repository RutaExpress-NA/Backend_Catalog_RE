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

import com.na.rutaexpress.catalog.model.ServiceShipping;
import com.na.rutaexpress.catalog.service.ServiceShippingService;

@RestController
@RequestMapping("/api/catalog/services")
public class ServicesShippingController {

    @Autowired
    private ServiceShippingService serviceShippingService;

    @GetMapping
    public ResponseEntity<List<ServiceShipping>> listar() {
        List<ServiceShipping> servicios = serviceShippingService.findAll();
        if (servicios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(servicios);
    }

    @PostMapping
    public ResponseEntity<ServiceShipping> guardar(@RequestBody ServiceShipping servicio) {
        ServiceShipping nuevo = serviceShippingService.save(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceShipping> buscar(@PathVariable Long id) {
        try {
            ServiceShipping servicio = serviceShippingService.findById(id);
            return ResponseEntity.ok(servicio);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceShipping> actualizar(@PathVariable Long id, @RequestBody ServiceShipping servicio) {
        try {
            ServiceShipping sp = serviceShippingService.findById(id);

            sp.setName(servicio.getName());
            sp.setDescription(servicio.getDescription());
            sp.setPrice(servicio.getPrice());
            sp.setActive(servicio.getActive());
            sp.setVehicleTypeRequired(servicio.getVehicleTypeRequired());

            serviceShippingService.save(sp);
            return ResponseEntity.ok(sp);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
