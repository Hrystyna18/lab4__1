package com.example.service;

import com.example.dto.ServiceDTO;

import java.util.List;

public interface IService {
    ServiceDTO getService(int id);
    List<ServiceDTO> getServices();
    ServiceDTO addService(ServiceDTO s);
    ServiceDTO updateService(ServiceDTO s);
    void deleteService(int id);
    double getServicesSum();
}
