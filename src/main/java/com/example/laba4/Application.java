package com.example.laba4;

import com.example.dto.ServiceDTO;
import com.example.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

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

    @RequestMapping(value = "/services", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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


