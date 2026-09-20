package com.na.rutaexpress.catalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.rutaexpress.catalog.model.ServiceShipping;
import com.na.rutaexpress.catalog.repository.ServiceShippingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceShippingService {

    @Autowired
    private ServiceShippingRepository serviceShippingRepository;

    public List<ServiceShipping> findAll() {
        return serviceShippingRepository.findAll();
    }

    public List<ServiceShipping> findActivos() {
        return serviceShippingRepository.findByActiveTrue();
    }

    public ServiceShipping findById(Long id) {
        return serviceShippingRepository.findById(id).get();
    }

    public ServiceShipping save(ServiceShipping serviceShipping) {
        return serviceShippingRepository.save(serviceShipping);
    }

}
