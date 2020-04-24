package com.tamu.happyloft.controller;

import com.tamu.happyloft.dto.ServiceDto;
import com.tamu.happyloft.dto.ServiceRequestDto;
import com.tamu.happyloft.model.UserServices;
import com.tamu.happyloft.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    public UserServices createService(@RequestBody ServiceDto serviceDto) {
        return serviceService.createService(serviceDto);
    }

    @PostMapping("/request")
    public String requestService(@RequestBody ServiceRequestDto serviceRequestDto) throws MessagingException {
        serviceService.requestService(serviceRequestDto);

        return "Service Updated";
    }
}
