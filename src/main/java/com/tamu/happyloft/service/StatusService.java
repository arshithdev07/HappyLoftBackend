package com.tamu.happyloft.service;

import com.tamu.happyloft.model.ServiceStatus;
import com.tamu.happyloft.repository.ServiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@Service
public class StatusService {

    @Autowired
    ServiceStatusRepository serviceStatusRepository;

    public List<ServiceStatus> fetchAllStatuses() {
        return serviceStatusRepository.findAll();
    }
}
