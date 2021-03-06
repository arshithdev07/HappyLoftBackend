package com.tamu.happyloft.repository;

import com.tamu.happyloft.model.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arshi on 4/3/2020.
 */
@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Integer> {

    List<ServiceCategory> findByServiceCategoryName(String serviceCategoryName);
}
