package com.tamu.happyloft.controller;

import com.tamu.happyloft.dto.ServiceDto;
import com.tamu.happyloft.model.UserServices;
import com.tamu.happyloft.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @GetMapping("/all")
    public List<UserServices> fetchAllServices() {
        return serviceService.fetchAllServices();
    }

    @PostMapping("/create")
    public String createService(@RequestBody ServiceDto serviceDto) {
        serviceService.createService(serviceDto);

        return "Service created successfully";
    }
}
