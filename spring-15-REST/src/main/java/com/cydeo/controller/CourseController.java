package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@ResponseBody + @Controller = @RestController     <- annotation on top of the class
    @GetMapping
    public List<CourseDTO> getAllCourses(){

        //return all courses
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId){

        return courseService.getCourseById(courseId);

    }


}
