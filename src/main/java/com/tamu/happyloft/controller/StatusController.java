package com.tamu.happyloft.controller;

import com.tamu.happyloft.model.ServiceStatus;
import com.tamu.happyloft.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/all")
    public List<ServiceStatus> fetchAllStatuses() {
        return statusService.fetchAllStatuses();
    }
}
