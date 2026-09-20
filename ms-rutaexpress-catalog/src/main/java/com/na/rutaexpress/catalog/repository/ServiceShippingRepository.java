package com.na.rutaexpress.catalog.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.na.rutaexpress.catalog.model.ServiceShipping;

public interface ServiceShippingRepository extends JpaRepository<ServiceShipping, Long> {
    List<ServiceShipping> findByActiveTrue();
}