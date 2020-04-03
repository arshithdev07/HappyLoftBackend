package com.tamu.happyloft.repository;

import com.tamu.happyloft.model.ServiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arshi on 4/3/2020.
 */
@Repository
public interface ServiceStatusRepository extends JpaRepository<ServiceStatus, Integer> {
}
