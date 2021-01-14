package com.example.mapper;

import com.example.dto.ServiceDTO;
import com.example.service.Service;
import org.springframework.stereotype.Component;

@Component
public class DTOMapper {
    public Service toEntity(ServiceDTO sDTO) {
        Service s = new Service(sDTO.id, sDTO.title, sDTO.price);
        return s;
    }

    public ServiceDTO toDto(Service s) {
        ServiceDTO serviceDTO = new ServiceDTO(s.id, s.title, s.price);
        return serviceDTO;
    }
}

