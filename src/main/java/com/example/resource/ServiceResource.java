package com.example.resource;

import com.example.dto.ServiceDTO;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ServiceResource {
    @Autowired
    private IService service;

    @GetMapping("/services/{id}")
    public ServiceDTO getService(@PathVariable int id){
        return service.getService(id);
    }

    @GetMapping("/services")
    public List<ServiceDTO> getServices() {
        return service.getServices();
    }

    @GetMapping("/services/calc")
    public double getServicesSum() {
        return service.getServicesSum();
    }

    @RequestMapping(value = "/services", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ServiceDTO addService(ServiceDTO sDTO) {
        return service.addService(sDTO);
    }

    @PutMapping("/services")
    public ServiceDTO getService(ServiceDTO sDTO) {
        return service.updateService(sDTO);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable int id) {
        service.deleteService(id);
    }
}
