package com.tamu.happyloft.controller;

import com.tamu.happyloft.model.ServiceCategory;
import com.tamu.happyloft.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arshi on 4/22/2020.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<ServiceCategory> fetchAllCategories() {
        return categoryService.fetchAllCategories();
    }
}
