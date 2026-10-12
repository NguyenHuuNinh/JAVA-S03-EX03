package com.example.Rikkeibb3.controller;

import com.example.Rikkeibb3.dto.ApiResponse;
import com.example.Rikkeibb3.model.Course;
import com.example.Rikkeibb3.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses() {
        List<Course> courses = service.getAllCourses();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched courses successfully", courses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable int id) {
        Course data = service.getCourseById(id);
        if (data != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Fetched course successfully", data));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Course not found", null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        Course created = service.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Course created successfully", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Course updated successfully", updated));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Course not found for update", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable int id) {
        Course deleted = service.deleteCourseById(id);
        if (deleted != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Course deleted successfully", deleted));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Course not found for deletion", null));
    }
}