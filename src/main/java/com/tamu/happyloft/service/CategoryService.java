package com.tamu.happyloft.service;

import com.tamu.happyloft.model.ServiceCategory;
import com.tamu.happyloft.repository.ServiceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@Service
public class CategoryService {

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    public List<ServiceCategory> fetchAllCategories() {
        return serviceCategoryRepository.findAll();
    }
}
