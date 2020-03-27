package com.tamu.happyloft.controller;

import com.tamu.happyloft.model.Course;
import com.tamu.happyloft.service.CoursesHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arshi on 3/26/2020.
 */
@RestController
public class CourseResource {

    @Autowired
    private CoursesHardcodedService courseManagementService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseManagementService.findAll();
    }
}