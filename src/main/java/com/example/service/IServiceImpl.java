package com.example.service;

import com.example.dto.ServiceDTO;
import com.example.mapper.DTOMapper;
import com.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class IServiceImpl implements IService {
    @Autowired
    private ServiceRepository rep;

    @Autowired
    private DTOMapper mapper;

    @Override
    public ServiceDTO getService(int id) {
        return mapper.toDto(rep.getService(id));
    }

    @Override
    public List<ServiceDTO> getServices() {
        return rep.getServices().stream().map(item -> mapper.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public ServiceDTO addService(ServiceDTO sDTO) {
        sDTO.validate();
        return mapper.toDto(rep.addService(mapper.toEntity(sDTO)));
    }

    @Override
    public ServiceDTO updateService(ServiceDTO sDTO) {
        sDTO.validate();
        return mapper.toDto(rep.updateService(mapper.toEntity(sDTO)));
    }

    @Override
    public void deleteService(int id) {
        rep.deleteService(id);
    }

    @Override
    public double getServicesSum() {
        return rep.getServices().stream().map(item -> item.price).reduce((x, y) -> x + y).get();
    }

}

