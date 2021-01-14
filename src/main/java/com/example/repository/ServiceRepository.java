package com.example.repository;

import com.example.exception.HttpException;
import com.example.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ServiceRepository {
    @PostConstruct
    public void initialization() {
        services = new ArrayList<>();
    }

    private List<Service> services;

    public Service getService(int id) {
        return services.stream()
                .filter(item -> item.id == id)
                .findFirst()
                .orElseThrow(() -> new HttpException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.code(), "Service with that id doesn`t exist"));
    }

    public List<Service> getServices() {
        return services;
    }

    public Service addService(Service s) {
        s.validate();
        services.add(s);
        return s;
    }

    public Service updateService(Service s) {
        s.validate();
        Service service = getService(s.id);
        service.id = s.id;
        service.title = s.title;
        service.price = s.price;

        return service;
    }

    public void deleteService(int id) {
        services.stream()
                .filter(item -> item.id == id)
                .findFirst()
                .orElseThrow(() -> new HttpException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.code, "Service with that id isn`t found"));
        services = services.stream().filter(item -> item.id != id).collect(Collectors.toList());
    }

    public double getServicesSum() {
        return services.stream().map(item -> item.price).reduce((x, y) -> x + y).get();
    }

}

